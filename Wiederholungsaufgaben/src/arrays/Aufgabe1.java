package arrays;

public class Aufgabe1 {

	public static void main(String[] args) {
		int [] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Das " + i + ". Element hat den Wert " + numbers[i]);
		}
	}
}
