package shoppingApp;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopApp {

	public static void main(String[] args) {

		// Produkte arraylist
		// Preis float
		// Anzahl int
		// Warenkorb arraylist
		// Checkout -----

		// für nachkomma stellen float und double

		boolean finish = false;

		Product Monitor = new Product("Monitor", 99.99, "geiles Teil");
		Product Handy = new Product("Handy", 999.99, "geiles Teil");
		Product Bohrer = new Product("Bohrer", 120.00, "ASMR erlebnis pur");
		Product Playstation= new Product("Playstation", 500.00, "Gamurrr");

		ArrayList<Product> angebote = new ArrayList<Product>();

		angebote.add(Handy);
		angebote.add(Bohrer);
		angebote.add(Monitor);
		
		angebote.add(2, Playstation);
		
		
		

//		for(Product p:angebote) {
//			System.out.println("Produkt name "+p.getName());
//		}

		ArrayList<Product> warenkorb = new ArrayList<Product>();
		

		Scanner sc = new Scanner(System.in);
		int auswahl;

		while (!finish) {
			System.out.println("schreib die Zahl die zu dein produkt gehört damit du es in den Warenkorb hinzufügst.");

			for (int i = 0; i < angebote.size(); i++) {
				System.out.println("(" + i + "): Produkt name " + angebote.get(i).getName() + " Preis "
						+ angebote.get(i).getPreis()

				);
			}
			System.out.println("(3) zum beenden!");

			auswahl = sc.nextInt();

			System.out.println("Auswahl: " + auswahl);

			if (auswahl > angebote.size() - 1 || auswahl < 0) {
				finish = true;
			} else {
				warenkorb.add(angebote.get(auswahl));
			}

//			if (auswahl==0) {
//				warenkorb.add(angebote.get(0));
//			}
//			if (auswahl==1) {
//				warenkorb.add(angebote.get(1));
//			}
//			if (auswahl==2) {
//				warenkorb.add(angebote.get(2));
//			}

		}

		double betrag = 0;
		System.out.println("Dein warenkorb sieht so aus:");
		for (int i = 0; i < warenkorb.size(); i++) {
			System.out.println("(" + i + "): Produkt name " + warenkorb.get(i).getName());
			betrag += warenkorb.get(i).getPreis();
		}
		

		System.out.println("Du musst " + betrag + " Euro Zahlen!");
	}

}
