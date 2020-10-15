package objects.ufo;

public class Projectile {

	private int x;
	private int y;
	private int width;
	private int height;
	private String image;
	private float yVelocity = 0.5f;

	public Projectile(int x, int y, int width, int height, String image) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	public void move() {
		y -= yVelocity;
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

	public String getImage() {
		return image;
	}

}
