package arrays;

public class Aufgabe3 {

	public static void main(String[] args) {
		int [] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)Math.pow(2, i);
			System.out.println(numbers[i]);
		}
		
	}
}
