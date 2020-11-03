package ufo;

import view.IGameObject;

public class Bullet implements IGameObject {

	private float x;
	private float y;
	private float speedY = 2;
	private int width;
	private int height;
	private String image;
	private boolean fromPlayer = true;

	public Bullet(int x, int y, int width, int height, String image) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	public void move() {
		if(fromPlayer) {
			y -= speedY;
		} else {
			y += speedY;
		}
	}
	
	public boolean isFromPlayer() {
		return fromPlayer;
	}

	public void setFromPlayer(boolean fromPlayer) {
		this.fromPlayer = fromPlayer;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public int getX() {
		return (int)x;
	}

	public int getY() {
		return (int)y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getImagePath() {
		return image;
	}

}
