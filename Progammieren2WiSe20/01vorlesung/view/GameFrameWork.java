
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

/**
 * GameFrameWork provides methods to simply draw shapes and images. To draw
 * images you need to implement the interface IGameObject, the image is
 * stretched by the given width and height. The framework provides to draw
 * Rectangles and Circles in a specific color and size. You just add the your
 * object and it is painted every frame. If you want to have motions, just
 * change your coordinates. Through the getX() and getY() Methods in the
 * interfaces and classes the framework get the current position. <br>
 * <br>
 * You can get notify at every frame. For that just implement the ITickable
 * interface. <br>
 * If you want to get notified when the mouse is clicked implement the
 * IMouseInput interface. <br>
 * If you want to get notified when a specific key is used implement the
 * IKeyboardInput interface. <br>
 * 
 * @author Stephi
 * @version 1.0
 * @see IGameObject
 * @see Shape
 * @see IKeyboardListener
 * @see IMouseListener
 * @see ITickableListener
 * @see IBackground
 */
public class GameFrameWork {
	private GameFrame gameFrame;
	private LinkedList<IKeyboardListener> keyInputs;
	private LinkedList<IMouseListener> mouseInputs;
	private LinkedList<Shape> gameShapes;
	private LinkedList<IGameObject> gameObjects;
	private LinkedList<Image> imageObjects;
	private LinkedList<ITickableListener> ticks;
	private LinkedList<Message> messages;
	private int delay = 16;
	private long time = 0;

	
	/**
	 * Creates an white window of the size 400x400 pixels. If you want to have a
	 * bigger window use the setSize(int x, int y) method.
	 */
	public GameFrameWork() {
		init();
	}

	private void init() {

		gameObjects = new LinkedList<>();
		imageObjects = new LinkedList<>();
		gameShapes = new LinkedList<>();
		messages = new LinkedList<Message>();

		ticks = new LinkedList<>();
		mouseInputs = new LinkedList<>();
		keyInputs = new LinkedList<>();

		gameFrame = new GameFrame(imageObjects, gameObjects, gameShapes);

		gameFrame.setGameObjects(gameObjects);
		gameFrame.setImageObjects(imageObjects);
		gameFrame.setGameShapes(gameShapes);
		gameFrame.setMessages(messages);

		gameFrame.setVisible(true);
		gameFrame.toFront();
		gameFrame.requestFocus();

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				long offset = System.currentTimeMillis()-time;				
				time = System.currentTimeMillis();
//				System.out.println(offset);
				for (ITickableListener tickable : ticks) {
					tickable.tick(offset);
					
				}
				gameFrame.update();
				
			}
		};
		Timer timer = new Timer();
		timer.schedule(timerTask, 30, delay);

		gameFrame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent event) {
				for (IKeyboardListener keys : keyInputs) {
					for (int key : keys.getKeys()) {
						if (event.getKeyCode() == key) {
							keys.keyDown(key);
						}
					}
				}
			}

		});
		gameFrame.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				for (IMouseListener mouse : mouseInputs) {
					mouse.mouseClicked();
				}

			}
		});

	}

	/**
	 * Sets the window size. If the width or height is not valid an
	 * {@link InvalidArgumentException} is thrown.
	 * 
	 * @param width  of the window
	 * @param height of the window
	 * @throws InvalidArgumentException when width or height is smaller than zero or
	 *                                  higher than the screen size the
	 *                                  {@link InvalidArgumentException} is thrown.
	 */
	public void setSize(int width, int height) throws InvalidArgumentException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if ((screenSize.getWidth() < width) || (screenSize.getHeight() < height) || (width < 0) || (height < 0)) {
			throw new InvalidArgumentException(
					"The window size is too large or too small. You want to set the window width height to " + width
							+ " and the height to " + height + ". The screenheight has the width "
							+ screenSize.getWidth() + " and the height: " + screenSize.getHeight());
		} else {
			gameFrame.setSize(width, height);
		}
	}

	/**
	 * Sets the background color to the RGB values. <br>
	 * <br>
	 * If red, green and blue are 0 the color is black. <br>
	 * If red, green and blue are 255 the color is white. <br>
	 * If red is 255 and blue and green is 0 the color is red. <br>
	 * 
	 * @param color Sets the background to the color
	 * @see Color
	 */
	public void setBackgroundColor(Color color) {
		gameFrame.setBackgroundColor(color);
	}

	/**
	 * Draws a rectangle at the x, y coordinate with the width and height. The
	 * rectangle has the color of the RGB values. If you change the coordinates the
	 * rectangle seems to move.
	 * 
	 * @param rectangle to draw
	 * @see Rectangle
	 */
	public void addRectangle(Rectangle rectangle) throws NullPointerException {
		if (rectangle != null) {
			synchronized (gameShapes) {
				gameShapes.add(rectangle);
			}
		} else {
			throw new NullPointerException("The rectangle object is null");
		}
	}

	/**
	 * Draws an oval at the x, y coordinate with the width and height. The oval has
	 * the color of the RGB values. If you change the coordinates the oval seems to
	 * move.
	 * 
	 * @param oval to draw
	 * @see Oval
	 */
	public void addOval(Oval oval) throws NullPointerException {
		if (oval != null) {
			synchronized (gameShapes) {
				gameShapes.add(oval);
			}
		} else {
			throw new NullPointerException("The oval object is null");
		}
	}

	/**
	 * Adds the gameobject to a list and draws it every frame. A gameobject could be
	 * every class which implements the interface IGameObject.
	 * 
	 * @param gameObject to draw
	 */
	public void addGameObject(IGameObject gameObject) throws NullPointerException {
		if (gameObject != null) {
			synchronized (gameObjects) {
				synchronized (imageObjects) {
					gameObjects.add(gameObject);
					try {
						imageObjects.add(ImageIO.read(new File(gameObject.getImagePath())));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			throw new NullPointerException("The gameoject is null");
		}
	}

	/**
	 * Removes the gameobject from the list, so it is not drawn anymore.
	 * 
	 * @param gameObject to remove from list
	 */
	public void removeGameObject(IGameObject gameObject) throws NullPointerException {
		if (gameObject != null) {
			synchronized (gameObjects) {
				synchronized (imageObjects) {
					int index = gameObjects.indexOf(gameObject);
					if (index >= 0) {
						imageObjects.remove(index);
						gameObjects.remove(index);
					}
				}
			}
		} else {
			throw new NullPointerException("The gameoject is null");
		}
	}

	/**
	 * Adds a class to a list, so that class is notified when a user clicks. Every
	 * class which implements the interface IMouseInput can be added.
	 * 
	 * @param mouseInput class to notify when a user clicks
	 */
	public void addIMouseInput(IMouseListener mouseInput) {
		if (mouseInput != null) {
			mouseInputs.add(mouseInput);
		} else {
			throw new NullPointerException("The mouseInput object is null");
		}
	}

	/**
	 * Removes a class from a list, so that class is not notified anymore when a
	 * user clicks.
	 * 
	 * @param mouseInput to remove from list
	 */
	public void removeIMouseInput(IMouseListener mouseInput) {
		if (mouseInput != null) {
			mouseInputs.remove(mouseInput);
		} else {
			throw new NullPointerException("The mouseInput object is null");
		}
	}

	/**
	 * Adds a class to a list, so that class is notified when a user press a
	 * specific key. Every class which implements the interface IKeyboardInput can
	 * be added.
	 * 
	 * @param keyInput class to notify when a user press a key
	 */
	public void addIKeyInput(IKeyboardListener keyInput) {
		if (keyInput != null) {
			keyInputs.add(keyInput);
		} else {
			throw new NullPointerException("The keyInput object is null");
		}
	}

	/**
	 * Removes a class from a list, so that class is not notified anymore when a
	 * user press a key.
	 * 
	 * @param keyInput class to remove from list
	 */
	public void removeIKeyboardInput(IKeyboardListener keyInput) {
		if (keyInput != null) {
			keyInputs.remove(keyInput);
		} else {
			throw new NullPointerException("The keyInput object is null");
		}
	}

	/**
	 * Notifies that class every time when a timer ticks and before new frame is
	 * drawn.
	 * 
	 * @param tickable class to notify at each timer tick
	 */
	public void addTick(ITickableListener tickable) throws NullPointerException {
		if (tickable != null) {
			ticks.add(tickable);
		} else {
			throw new NullPointerException("The tickable object is null");
		}
	}

	/**
	 * Removes the class from a list so the class is not notified anymore at a timer
	 * tick.
	 * 
	 * @param tickable to remove from list
	 */
	public void removeTick(ITickableListener tickable) {
		if (tickable != null) {
			ticks.remove(tickable);
		} else {
			throw new NullPointerException("The tickable object is null");
		}
	}

	/**
	 * Draws a background every frame
	 * 
	 * @param background to draw
	 */
	public void setBackground(IBackground background) {
		if(background != null) {
			gameFrame.addBackground(background);
		}  else {
			throw new NullPointerException("The background object is null");
		}
	}

	/**
	 * Removes that background so it is not drawn anymore
	 * 
	 * @param background to remove
	 */
	public void removeBackground(IBackground background) {
		if(background != null) {
			gameFrame.addBackground(null);			
		}  else {
			throw new NullPointerException("The background object is null");
		}
	}


	/**
	 * Shows a message at a specific x, y coordinate. That message is displayed in
	 * the given color and text size.
	 * 
	 * @param message to show
	 * @see Message
	 */
	public void addMessage(Message message) {
		if(message != null ) {
			synchronized (message) {
				messages.add(message);			
			}
		}  else {
			throw new NullPointerException("The message object is null");
		}
	}

	public void removeMessage(Message message) {
		if(message != null ) {
			synchronized (message) {
				messages.remove(message);	
			}
		}  else {
			throw new NullPointerException("The message object is null");
		}
	}

	//TODO camera sight
	public void setCamera(Camera camera) {
		if(camera != null) {
			gameFrame.setCamera(camera);
		}  else {
			throw new NullPointerException("The camera object is null");
		}
	}
	
}
