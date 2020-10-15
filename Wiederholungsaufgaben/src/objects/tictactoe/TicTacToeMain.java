package objects.tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		Scanner scanner = new Scanner(System.in);

		boolean playAgain = false;
		do {
			while(!ticTacToe.isEnd()) {
				printNextTurn(ticTacToe);		
				ticTacToe.setSymbol(scanner.nextInt());
			}
			printGameEnd(ticTacToe);
			System.out.println("Play again? (y/n)");
			String nextGame = scanner.next();
			if(nextGame.equalsIgnoreCase("y") || nextGame.equalsIgnoreCase("j")) {
				playAgain = true;
				ticTacToe = new TicTacToe();
			} else {
				playAgain = false;
			}
		}
		while(playAgain);
		
		scanner.close();
	}


	private static void printGameEnd(TicTacToe ticTacToe) {
		printField("Game is over.", ticTacToe);
		
		if(ticTacToe.isDrawn()) {
			System.out.println("The game is drawn");
		}
		else {
			System.out.println("The winner is " + (ticTacToe.getWinner() == TicTacToe.SYMBOL_O ? "O" : "X") + ". Congratulation!");
		}
	}


	private static void printNextTurn(TicTacToe ticTacToe) {
		String message = "It's players " + (ticTacToe.getPlayersTurn() == TicTacToe.SYMBOL_O ? " O " : " X ") + " turn. Please enter a digit between 0 and " + (ticTacToe.getField().length*ticTacToe.getField().length-1);
		printField(message, ticTacToe);
	}
	
	private static void printField(String message, TicTacToe ticTacToe) {
		System.out.println(message);
		
		for (int row = 0; row < ticTacToe.getField().length; row++) {
			System.out.println("\n -------------------");
			System.out.print(" | ");
			for (int col = 0; col < ticTacToe.getField().length; col++) {
				if(ticTacToe.getField()[row][col] == TicTacToe.SYMBOL_O) {
					System.out.print(" O ");
				} else if(ticTacToe.getField()[row][col] == TicTacToe.SYMBOL_X) {
					System.out.print(" X ");
				} else {
					System.out.print("   ");
				}
				System.out.print(" | ");				
			}
		}
		System.out.println("\n -------------------");
	}

}
