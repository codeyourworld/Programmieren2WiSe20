package view;

import java.awt.Color;
import java.awt.Font;

public class Message {

	private String message;
	private int x;
	private int y;
	private float textSize;
	private Color color;
	private Font font;
	
	
	public Message(String message, int x, int y, int textSize, Color color) {
		super();
		this.message = message;
		this.x = x;
		this.y = y;
		this.textSize = textSize;
		this.color = color;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public float getTextSize() {
		return textSize;
	}


	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Font getFont() {
		return font;
	}


	public void setFont(Font font) {
		this.font = font;
	}
	
	
	
}
