package objects.flappybird;

public class Bird {

	private int x;
	private int y;
	private int width;
	private int height;
	private float yVelocity = 0.2f;
	private String imagePath;
	private int points;
	private float jumpVelocity = -10.5f;

	public Bird(int x, int y, int width, int height, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
	}

	public void increasePoints() {
		points++;
	}
	
	public void flap() {
		y += jumpVelocity;
	}
	
	public void move() {
		y += yVelocity;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getPoints() {
		return points;
	}

}
