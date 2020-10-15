package objects.tictactoe;

import java.util.Random;

public class TicTacToe {

	private static final int FIELD_SIZE = 3;
	public static final int SYMBOL_O = 2;
	public static final int SYMBOL_X = 1;
	public static final int NO_SYMBOL = 0;
	private int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
	private boolean isEnd = false;
	private int playersTurn = NO_SYMBOL;
	private int winner = NO_SYMBOL;
	private boolean isDrawn = false;

	public TicTacToe() {
		Random random = new Random();
		playersTurn = random.nextBoolean() ? SYMBOL_O : SYMBOL_X;
	}
	
	public boolean setSymbol(int index) {
		if (playersTurn != SYMBOL_O && playersTurn != SYMBOL_X) {
			return false;
		}
		if (index < 0 || index >= FIELD_SIZE * FIELD_SIZE) {
			return false;
		}
		if (field[index / FIELD_SIZE][index % FIELD_SIZE] == NO_SYMBOL) {
			field[index / FIELD_SIZE][index % FIELD_SIZE] = playersTurn;

			if(isWon(playersTurn) || isDraw()) {
				isEnd = true;
			}
			nextTurn();
		}
		
		return true;
	}

	private boolean isDraw() {
		if(!isWon(SYMBOL_O) && !isWon(SYMBOL_X)) {
			for (int row = 0; row < field.length; row++) {
				for (int col = 0; col < field.length; col++) {
					if(field[row][col] == NO_SYMBOL) {
						return false;
					}
				}
			}
			isDrawn = true;
			return true;
		}
		return false;
	}
	
	private boolean isWon(int symbol) {
		System.out.println("check if " + symbol + " has won");
		boolean hasWon = checkCol(symbol) || checkRow(symbol) || checkDiagonal(symbol);
		if(hasWon) {
			winner = symbol;
		}
		return hasWon;
	}

	private boolean checkDiagonal(int symbol) {
		int counter = 0;
		for (int row = 0; row < field.length; row++) {
			if (field[row][row] == symbol) {
				counter++;
			}
		}
		if (counter == FIELD_SIZE) {
			return true;
		}
		counter = 0;
		for (int row = 0; row < field.length; row++) {
			if (field[row][FIELD_SIZE - (row + 1)] == symbol) {
				counter++;
			}
		}
		if (counter == FIELD_SIZE) {
			return true;
		}
		return false;
	}

	private boolean checkRow(int symbol) {
		for (int row = 0; row < field.length; row++) {
			int counter = 0;
			for (int col = 0; col < field.length; col++) {
				if (field[col][row] == symbol) {
					counter++;
				}
			}
			if (counter == FIELD_SIZE) {
				return true;
			}
		}
		return false;
	}

	private boolean checkCol(int symbol) {
		for (int col = 0; col < field.length; col++) {
			int counter = 0;
			for (int row = 0; row < field.length; row++) {
				if (field[col][row] == symbol) {
					counter++;
				}
			}
			if (counter == FIELD_SIZE) {
				return true;
			}
		}
		return false;
	}

	private void nextTurn() {
		if (playersTurn == SYMBOL_O) {
			playersTurn = SYMBOL_X;
		} else {
			playersTurn = SYMBOL_O;
		}
	}

	public int[][] getField() {
		return field;
	}
	
	public int getPlayersTurn() {
		return playersTurn;
	}
	
	public int getWinner() {
		return winner;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
	public boolean isDrawn() {
		return isDrawn;
	}
	
	
}
