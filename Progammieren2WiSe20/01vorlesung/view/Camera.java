package view;

/**
 * 
 * Use the camera to change the view and get the feeling the objects are moving. 
 * For that change the coordinates of the camera.
 * The position of the camera is in the middle of the screen.
 * 
 * @author Stephi
 * @version 1.0
 */
public class Camera {

	private int x;
	private int y;
	private float veloX;
	private float veloY;

	/**
	 * 
	 * Use the camera to change the view and get the feeling the objects are moving. 
	 * For that change the coordinates of the camera.
	 * The position of the camera is in the middle of the screen.
	 * 
	 * @param x position of the camera
	 * @param y position of the camera
	 */
	public Camera(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void move() {
//		System.out.println(x);
		x += veloX;
		y += veloY;
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

	public float getVeloX() {
		return veloX;
	}

	public void setVeloX(float veloX) {
		this.veloX = veloX;
	}

	public float getVeloY() {
		return veloY;
	}

	public void setVeloY(float veloY) {
		this.veloY = veloY;
	}

	
}
