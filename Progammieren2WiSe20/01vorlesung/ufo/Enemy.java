package ufo;

import java.util.Random;

public class Enemy {

	private float x;
	private float y;
	private float velocityX = 0.4f;
	private int height;
	private int width;
	private int counterShots = 7;
	private boolean hit = false;
	private String image;
	
	//alt + shift + s
	public Enemy(int x, int y, int height, int width, String image) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;
	}

	public void move() {
		x += velocityX;
	}
	
	public boolean shoot() {
		boolean isShooting = false;
		if(counterShots > 0) {
			Random rand = new Random();
			int number = rand.nextInt(2);
			if(number == 0) {
				isShooting = true;
				counterShots--;
			}
		}
		return isShooting;
	}
	
	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public int getCounterShots() {
		return counterShots;
	}

	public void setCounterShots(int counterShots) {
		this.counterShots = counterShots;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public int getX() {
		return (int)x;
	}

	public int getY() {
		return (int)y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getImage() {
		return image;
	}
	
	
	
	
}
