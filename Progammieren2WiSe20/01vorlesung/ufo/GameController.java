package ufo;

import java.util.ArrayList;

public class GameController {

	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Bullet> bullets = new ArrayList<>();
	private Player player;

	public void init() {
		int screenWidth = 700;
		int screenHeight = 600;

		int scaling = screenWidth / 10;
		enemies.add(new Enemy(-scaling, screenHeight / 4, scaling, scaling, "01Vorlesung\\assets\\ufo20.png"));

		for (int i = 0; i < 10; i++) {
			Enemy last = enemies.get(enemies.size() - 1);
			enemies.add(new Enemy(last.getX() - 2 * scaling, last.getY(), last.getHeight(), last.getWidth(), last.getImage()));
		}

		player = new Player(screenWidth / 2 - scaling / 2, screenHeight - 2 * scaling, scaling, scaling,
				"01Vorlesung\\assets\\ship22.png");
	}
}
