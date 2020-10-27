package view;

import java.awt.Color;

public class GameMain {

	public static void main(String[] args) {
		GameFrameWork controller = new GameFrameWork();
		controller.setSize(800, 800);
		controller.setBackgroundColor(new Color(0, 0, 0));
//		controller.drawRectangle(200, 200, 400, 400, 0, 180, 180);
//		controller.drawOval(200, 200, 400, 400, 180, 180, 180);
	}
}
