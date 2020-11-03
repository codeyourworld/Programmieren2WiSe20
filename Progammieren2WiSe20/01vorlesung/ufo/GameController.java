package ufo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class GameController implements ITickableListener, IKeyboardListener{

	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Bullet> bullets = new ArrayList<>();
	private Player player;
	private GameFrameWork gameFrameWork;
	private int screenWidth = 700;
	private int screenHeight = 600;
	public static final String ENEMY_IMG = "01Vorlesung\\assets\\ufo20.png";
	public static final String PLAYER_IMG = "01Vorlesung\\assets\\ship22.png";
	public static final String BULLET_IMG = "01Vorlesung\\assets\\projectile06.png";
	public static final String BACKGROUND_IMG = "01Vorlesung\\assets\\space01.jpg";
	private Message scoreMsg = new Message("0", screenWidth - 70, screenHeight - 70, 28, Color.WHITE);
	private Message reloadMsg = new Message("Reload", screenWidth - 200, 100, 28, Color.RED);
	
	public void init() {
		gameFrameWork = new GameFrameWork();
		gameFrameWork.setSize(screenWidth, screenHeight);
		gameFrameWork.setBackground(new Backgroud(BACKGROUND_IMG));

		int scaling = screenWidth / 10;
		enemies.add(new Enemy(-scaling, screenHeight / 4, scaling, scaling, ENEMY_IMG));
		gameFrameWork.addGameObject(enemies.get(0));

		for (int i = 0; i < 10; i++) {
			addEnemy();
		}

		player = new Player(screenWidth / 2 - scaling / 2, screenHeight - 2 * scaling, scaling, scaling,
				PLAYER_IMG);
		gameFrameWork.addGameObject(player);
		gameFrameWork.addTick(this);
		gameFrameWork.addIKeyInput(this);
		gameFrameWork.addMessage(scoreMsg);
		
	}

	private void addEnemy() {
		int scaling = screenWidth / 10;
		Enemy last = enemies.get(enemies.size() - 1);
		Enemy enemy = new Enemy(last.getX() - 5 * scaling, last.getY(), last.getHeight(), last.getWidth(), last.getImagePath());
		enemies.add(enemy);
		gameFrameWork.addGameObject(enemy);
	}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE, KeyEvent.VK_R};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		if(key == KeyEvent.VK_SPACE) {
			int scaling = player.getWidth() / 2;
			if(player.shoot()) {
				Bullet bullet = new Bullet(player.getX() + player.getWidth()/2 - scaling/2, player.getY() - scaling, scaling, scaling, BULLET_IMG);
				bullets.add(bullet);
				gameFrameWork.addGameObject(bullet);
				if(player.getMunition() == 0) {
					gameFrameWork.addMessage(reloadMsg);
				}
			}
			
		} else if(key == KeyEvent.VK_R) {
			gameFrameWork.removeMessage(reloadMsg);
			player.setMunition(player.getMaxMunition());
		}
	}

	@Override
	public void tick(long elapsedTime) {
		moveEnemies();
		moveBullets();
		
		if(checkCollision()) {
			addEnemy();
			player.setScore(player.getScore() + 1);
			System.out.println("Score " + player.getScore());
			scoreMsg.setMessage(String.valueOf(player.getScore()));
		}
	}
	

	public boolean checkCollision() {
		for(Enemy enemy : enemies) {
			for(Bullet bullet : bullets) {
				if(isCollided(enemy, bullet)) {
					return true;
				}
				
			}
		}
		return false;
	}

	protected boolean isCollided(Enemy enemy, Bullet bullet) {
		boolean isCollided = false;
		if((enemy.getX() < bullet.getX() + bullet.getWidth()) && 
				(enemy.getX() + enemy.getWidth() > bullet.getX()) && 
				(enemy.getY() < bullet.getY() + bullet.getHeight()) &&
				(enemy.getY() + enemy.getHeight() > bullet.getY())) {
			gameFrameWork.removeGameObject(enemy);
			enemies.remove(enemy);
			gameFrameWork.removeGameObject(bullet);
			bullets.remove(bullet);
			System.out.println("Collided");
			isCollided = true;
		}
		return isCollided;
	}
	
	
	private void moveBullets() {
		for(Bullet bullet : bullets) {
			bullet.move();
		}

		if(!bullets.isEmpty()) {
			if(bullets.get(0).getY() + bullets.get(0).getHeight() < 0) {
				gameFrameWork.removeGameObject(bullets.get(0));
				bullets.remove(0);
			}			
		}
	}

	private void moveEnemies() {
		for(Enemy enemy : enemies) {
			enemy.move();
		}

		if(enemies.get(0).getX() > screenWidth) {
			gameFrameWork.removeGameObject(enemies.get(0));
			enemies.remove(0);
			addEnemy();
		}
	}
	
	
	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.init();
	}
}
