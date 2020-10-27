package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Shape> gameShapes = new LinkedList<Shape>();
	private LinkedList<IGameObject> gameObjects = new LinkedList<IGameObject>();
	private LinkedList<Image> imageObjects = new LinkedList<Image>();
	private LinkedList<Message> messages = new LinkedList<Message>();
	private Image backgroundImage = null;
	private Color backgroundColor = Color.WHITE;
	private Dimension dimension;
	private Message message;
	private int textSize = 0;
	private Color messageColor = Color.BLACK;
	private int messageX = 0;
	private int messageY = 0;

	public GamePanel(Dimension dimension) {
		this.dimension = dimension;
		this.backgroundColor = new Color(255, 255, 255);
		setPreferredSize(dimension);
		setSize(dimension);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(backgroundColor);
		g2.fillRect(0, 0, dimension.width, dimension.height);

		if (backgroundImage != null) {
			g2.drawImage(backgroundImage, 0, 0, dimension.width, dimension.height, null);
		}

		for (Iterator<Shape> itShapes = gameShapes.iterator(); itShapes.hasNext();) {
			Shape shape = (Shape) itShapes.next();
			
			g2.setColor(shape.getColor());
			if (shape instanceof Rectangle) {
				g2.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			} else {
				g2.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
		}

		synchronized (gameObjects) {
			synchronized (imageObjects) {
				Iterator<IGameObject> itGameObj = gameObjects.iterator();
				Iterator<Image> itImage = imageObjects.iterator();
				while (itImage.hasNext()) {
					Image image = itImage.next();
					IGameObject gameObject = itGameObj.next();
					
					if(gameObject instanceof IChangeableColor) {
						BufferedImage bufImage = (BufferedImage) image;
						g2.drawImage(
								((IChangeableColor) gameObject).getBufferedImage(), 
								gameObject.getX(), 
								gameObject.getY(),
								gameObject.getWidth(), 
								gameObject.getHeight(), 
								null);
						
					} else {
						g2.drawImage(
								image, 
								gameObject.getX(), 
								gameObject.getY(),
								gameObject.getWidth(), 
								gameObject.getHeight(), 
								null);
						
					}
				}
//				for (int i = 0; i < imageObjects.size(); i++) {
//					if(gameObjects.get(i) instanceof IChangeableColor) {
//						BufferedImage bufImage = (BufferedImage) imageObjects.get(i);
//						g2.drawImage(((IChangeableColor) gameObjects.get(i)).getBufferedImage(), gameObjects.get(i).getX(), gameObjects.get(i).getY(),
//								gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight(), null);
//						
//					} else {
////						System.out.println("x: " + gameObjects.get(i).getX() + ", " + gameObjects.get(i).getWidth());
//						g2.drawImage(imageObjects.get(i), gameObjects.get(i).getX(), gameObjects.get(i).getY(),
//								gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight(), null);
//						
//					}
//				}
			}
		}

		synchronized (messages) {
			for (Iterator<Message> itMessage = messages.iterator(); itMessage.hasNext();) {
				Message message = (Message) itMessage.next();
				
				g2.setColor(message.getColor());
				g2.setFont(g2.getFont().deriveFont(message.getTextSize()));
				g2.drawString(message.getMessage(), message.getX(), message.getY());			
			}			
		}
	}

	public void setGameObjects(LinkedList<IGameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public void setBackground(IBackground background) {
		try {
			backgroundImage = ImageIO.read(new File(background.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setImageObjects(LinkedList<Image> imageObjects) {
		this.imageObjects = imageObjects;
	}


	public void setGameShapes(LinkedList<Shape> gameShapes) {
		this.gameShapes = gameShapes;
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		dimension = new Dimension(width, height);
	}

	public void showMessage(Message message) {
		this.message = message;
	}

	public void setBackgroundColor(Color color) {
		backgroundColor = color;
		
	}

	public void setMessages(LinkedList<Message> messages) {
		this.messages = messages; 
	}

}
