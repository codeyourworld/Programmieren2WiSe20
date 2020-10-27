package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private int width = 400;
	private int height = 400;

	public GameFrame(LinkedList<Image> imageObjects, LinkedList<IGameObject> gameObjects, LinkedList<Shape> gameShapes) {
		panel = new GamePanel(new Dimension(width, height));
		panel.setImageObjects(imageObjects);
		panel.setGameObjects(gameObjects);
		panel.setGameShapes(gameShapes);
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(width, height));
	    pack();
		setVisible(true);
	}
	

	public void setSize(int width, int height) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setSize(width, height);
				setPreferredSize(new Dimension(width, height));
				pack();
				setVisible(true);
			}
		});
	}


	public void setBackgroundColor(Color color) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setBackgroundColor(color);
				repaint();
			}
		});
	}
	
	public void setGameObjects(LinkedList<IGameObject> gameObjects) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setGameObjects(gameObjects);
			}
		});
	}

	public void setBackground(IBackground background) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setBackground(background);
			}
		});
	}
	
	public void setImageObjects(LinkedList<Image> imageObjects) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setImageObjects(imageObjects);
			}
		});
	}

	public void setGameShapes(LinkedList<Shape> gameShapes) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setGameShapes(gameShapes);
			}
		});
	}

	public void addBackground(IBackground background) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setBackground(background);
			}
		});
	}

	
	public void update() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.repaint();
				repaint();
			}
		});
	}



	public void setMessages(LinkedList<Message> messages) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				panel.setMessages(messages);
			}
		});		
	}


	public void setCamera(Camera camera) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
//				panel.setCamera(camera);
			}
		});		
	}
}
