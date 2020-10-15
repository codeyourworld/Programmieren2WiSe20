package arrays;

import java.util.Random;

public class Aufgabe4 {

	public static void main(String[] args) {
		int [] numbers = new int[5];
		Random random = new Random();

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}

		calc_mean(numbers);
		
	}

	private static float calc_mean(int[] numbers) {
		float mittelwert = 0;
		
		System.out.println("Der Mittelwert der Zahlen ");
		
		for (int i = 0; i < numbers.length; i++) {
			mittelwert += numbers[i];
			System.out.println(numbers[i]);
		}
		
		mittelwert /= numbers.length;
		System.out.println("ist " + mittelwert);

		return mittelwert;
	}
}
