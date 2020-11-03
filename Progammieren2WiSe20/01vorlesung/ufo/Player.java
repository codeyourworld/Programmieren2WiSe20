package ufo;

import view.IGameObject;

public class Player implements IGameObject{

	// formatieren strg shift f
	private int maxMunition = 5;
	private float x;
	private float y;
	private float speedX = 0.4f;
	private int width;
	private int height;
	private String image;
	private int health;
	private int munition = maxMunition;
	private int score;

	// alt shift s
	public Player(int x, int y, int width, int height, String image) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	public void move(boolean left) {
		if (left) {
			x -= speedX;
		} else {
			x += speedX;
		}
	}

	public boolean reload() {
		boolean isReloading = false;
		if (munition < maxMunition) {
			munition = maxMunition;
			isReloading = true;
		}
		return isReloading;
	}

	public boolean shoot() {
		boolean isShooting = false;
		if (munition > 0) {
			munition--;
			isShooting = true;
		}
		return isShooting;
	}

	public int getMaxMunition() {
		return maxMunition;
	}

	public void setMaxMunition(int maxMunition) {
		this.maxMunition = maxMunition;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMunition() {
		return munition;
	}

	public void setMunition(int munition) {
		this.munition = munition;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getX() {
		return (int)x;
	}

	public int getY() {
		return (int)y;
	}

	public float getSpeedX() {
		return speedX;
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
