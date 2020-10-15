package objects.flappybird;

public class Pipe {

	private int x;
	private int y;
	private int width;
	private int height;
	private float xVelocity = -0.3f;
	private String imagePath;

	public Pipe(int x, int y, int width, int height, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
	}

	public void move() {
		x += xVelocity;
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

}
