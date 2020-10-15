package arrays;

public class Aufgabe2 {

	public static void main(String[] args) {
		int [] numbers = new int[50];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i * 2 + 1;
		}
		
		System.out.println("Numbers hat folgende Werte:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);			
		}
	}
}
