package objects.ufo;

import java.util.ArrayList;
import java.util.Iterator;

public class UfoController {

	private static final String UFO_IMG = "";
	private static final String PROJECTILE_IMG = "";
	private static final String SHIP_IMG = "";
	
	private int screenWidth = 1000;
	private int screenHeight = 700;

	private Ship ship;
	private ArrayList<Ufo> ufos = new ArrayList<>();
	private ArrayList<Projectile> projectiles= new ArrayList<>();
	
	private int points = 0;
	
	public void init() {
		int scaling = screenHeight / 7;	
		ship = new Ship(screenWidth/2 - scaling/2, screenHeight - 2*scaling, scaling, scaling, SHIP_IMG);

		scaling = screenHeight / 9;
		ufos.add(new Ufo(-2*scaling, scaling, scaling, scaling, UFO_IMG));
		for (int i = 0; i < 10; i++) {
			addUfo();
		}
	}

	public void timer() {
		moveUfos();		
		moveProjectiles();
		if(checkCollision()) {
			points++;
		}
	}

	private void moveProjectiles() {
		for (Projectile projectile : projectiles) {
			projectile.move();
		}
		if(projectiles.get(projectiles.size()-1).getY() < -projectiles.get(projectiles.size()-1).getHeight()) {
			projectiles.remove(projectiles.size()-1);
		}
	}

	private void moveUfos() {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		if(ufos.get(ufos.size()-1).getX() > screenWidth + ufos.get(ufos.size()-1).getWidth()) {
			ufos.remove(ufos.size()-1);
			addUfo();
		}
	}

	public void tapp() {
		int scaling = screenHeight / 5;
		projectiles.add(new Projectile(screenWidth/2 - scaling/2, ship.getY() - scaling, scaling, scaling, PROJECTILE_IMG));
	}
	
	private void addUfo() {
		ufos.add(new Ufo(ufos.get(ufos.size()-1).getX() - 100, ufos.get(ufos.size()-1).getY(), ufos.get(ufos.size()-1).getWidth(), ufos.get(ufos.size()-1).getHeight(), ufos.get(ufos.size()-1).getImage()));
	}	

	private boolean checkCollision() {
		boolean collided = false;
		for (Iterator<Projectile> itPro = projectiles.iterator(); itPro.hasNext();) {
			Projectile projectile = (Projectile) itPro.next();
			for (Iterator<Ufo> itUfo = ufos.iterator(); itUfo.hasNext();) {
				Ufo ufo = (Ufo) itUfo.next();
				if(isCollided(ufo, projectile)) {
					itPro.remove();
					itUfo.remove();
					collided = true;
				}
			}
		}
		return collided;
	}
	
	private boolean isCollided(Ufo ufo, Projectile projectile) {
		//first check vertical overlap than check horizontal overlap
		if((((ufo.getX() < projectile.getX()) && (ufo.getX() + ufo.getWidth() > projectile.getX())) || 	
				((ufo.getX() > projectile.getX()) && (ufo.getX() < projectile.getX() + projectile.getWidth()))) &&
				((ufo.getY() < projectile.getY() && (ufo.getY() + ufo.getHeight() > projectile.getY())) || 
				(ufo.getY() > projectile.getY() && (ufo.getY() < projectile.getY() + projectile.getHeight())))) {
			return true;
		}
		return false;
	}
}
