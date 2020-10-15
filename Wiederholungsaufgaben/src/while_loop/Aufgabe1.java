package while_loop;

public class Aufgabe1 {

	public static void main(String[] args) {

		int x = 1;

		System.out.println("Die werte von x sind: ");

		while (x <= 200) {
			System.out.println(x);
			if (x % 5 == 0) {
				x += 3;
			} else {
				x += 1;
			}

		}
	}

}
