package while_loop;

public class Aufgabe3 {

	public static void main(String[] args) {
		int number = 1;
		int counter = 0;
		
		while(counter < 5) {
			if(number % 3 == 0 && number % 5 == 0) {
				counter += 1;
				System.out.println(counter + ": Die Zahl " + number + " ist sowohl durch 3 als auch durch 5 teilbar");
			}
			number += 1;
		}
	}
	
}
