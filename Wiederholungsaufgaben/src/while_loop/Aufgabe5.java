package while_loop;

import java.util.Scanner;

public class Aufgabe5 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Bitte gib eine Zahl ein:");
		int number = keyboard.nextInt();
		keyboard.close();

		if (isPrime(number)) {
			System.out.println("Die Zahl " + number + " ist eine Primzahl.");
		} else {
			System.out.println("Die Zahl " + number + " ist keine Primzahl.");
		}

	}

	private static boolean isPrime(int number) {

		int counter = 3;

		if (number < 2) {
			return false;
		}

		if (number == 2) {
			return true;
		} else if (number % 2 == 0) {
			return false;
		}

		while (counter <= Math.sqrt(number)) {
			if (number % counter == 0) {
				return false;
			}
			counter += 2;
		}

		return true;
	}
}
