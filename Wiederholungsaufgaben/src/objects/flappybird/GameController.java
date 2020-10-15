package objects.flappybird;

import java.util.ArrayList;
import java.util.Random;

public class GameController {

	private static final String BIRD_IMG = "";
	private static final String UPPER_PIPE_IMG = "";
	private static final String LOWER_PIPE_IMG = "";
	
	private int screenWidth = 1000;
	private int screenHeight = 700;

	private Bird bird;
	private ArrayList<Pipe> pipes = new ArrayList<>();
	private boolean gameOver = false;
	private boolean betweenPipes = false;
	
	public void init() {
		int scaling = screenHeight / 8;
		bird = new Bird(2*scaling, 2*scaling, scaling, scaling, BIRD_IMG);
		
		scaling = scaling / 7;
		Random rand = new Random();
		int height = rand.nextInt(screenHeight - 3*scaling);
		
		Pipe upperPipe = new Pipe(screenWidth, 0, scaling, height + scaling, UPPER_PIPE_IMG);
		Pipe lowerPipe = new Pipe(upperPipe.getX(), height + 2* scaling, upperPipe.getWidth(), screenHeight, LOWER_PIPE_IMG);
		pipes.add(upperPipe);
		pipes.add(lowerPipe);
		
		for (int i = 0; i < 10; i++) {
			addNewPipePair(scaling, rand);
		}
				
	}

	private void addNewPipePair(int scaling, Random rand) {
		int height;
		Pipe lastPipe = pipes.get(pipes.size() - 1);
		height = rand.nextInt(screenHeight - 3*scaling);
		pipes.add(new Pipe(lastPipe.getX() + 5*scaling, 0, lastPipe.getWidth(), height + scaling, UPPER_PIPE_IMG));
		pipes.add(new Pipe(lastPipe.getX() + 5*scaling, height + 2*scaling, lastPipe.getWidth(), screenHeight, LOWER_PIPE_IMG));
	}
	
	private boolean isCollided(Pipe pipe, Bird bird) {
		//first check vertical overlap than check horizontal overlap
		if((((pipe.getX() < bird.getX()) && (pipe.getX() + pipe.getWidth() > bird.getX())) || 	
				((pipe.getX() > bird.getX()) && (pipe.getX() < bird.getX() + bird.getWidth()))) &&
				((pipe.getY() < bird.getY() && (pipe.getY() + pipe.getHeight() > bird.getY())) || 
				(pipe.getY() > bird.getY() && (pipe.getY() < bird.getY() + bird.getHeight())))) {
			return true;
		}
		return false;
	}

	
	
	public void timer() {
		bird.move();
		for (Pipe pipe : pipes) {
			pipe.move();
		}
		
		if(checkCollision() || checkGameOver()) {
			gameOver = true;
		}
		else {
			checkPoints();
		}
		//TODO show point
		//TODO show gameover
		//end game at game over
	}

	
	private void checkPoints() {
		Pipe pipe = pipes.get(0);
		if(!betweenPipes) {
			if(bird.getX() + bird.getWidth() > pipe.getX() && bird.getX() < pipe.getX() + pipe.getWidth()) {
				betweenPipes = true;
			}
		} else {
			if(bird.getX() > pipe.getX() + pipe.getWidth()) {
				betweenPipes = false;
				bird.increasePoints();
			}
		}
		
	}

	private boolean checkGameOver() {
		boolean isOutOfWindow = false;
		if((bird.getY() + bird.getHeight() >= screenHeight) || (bird.getY() <= 0)) {
			isOutOfWindow = true;
		}
		return isOutOfWindow;
	}

	private boolean checkCollision() {
		boolean isCollided = false;
		if(pipes.size() >= 2) {
			isCollided = isCollided(pipes.get(0), bird) || isCollided(pipes.get(1), bird);
		}
		return isCollided;
	}

	public void tapp() {
		bird.flap();
	}
}
