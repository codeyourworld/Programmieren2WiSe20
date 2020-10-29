package draw;

import java.awt.Color;

import view.GameFrameWork;
import view.ITickableListener;
import view.Oval;
import view.Rectangle;

public class Draw implements ITickableListener {

	private Rectangle rect;
	
	public void init() {
		rect = new Rectangle(0, 0, 150, 50, Color.GREEN);
		GameFrameWork gameFrameWork = new GameFrameWork();
		gameFrameWork.setSize(500, 400);
		gameFrameWork.addRectangle(rect);
		gameFrameWork.addOval(new Oval(100, 0, 100, 200, Color.BLUE));
		gameFrameWork.setBackgroundColor(Color.BLACK);
		gameFrameWork.addGameObject(new Cat(50, 100, 200, 200, "01Vorlesung\\assets\\cat.jpg"));
		gameFrameWork.addTick(this);
	}
	
	public static void main(String[] args) {
		Draw drawer = new Draw();
		drawer.init();
	}

	@Override
	public void tick(long elapsedTime) {
		rect.setX((int)(rect.getX() + 0.2*elapsedTime));
		
	}
}
