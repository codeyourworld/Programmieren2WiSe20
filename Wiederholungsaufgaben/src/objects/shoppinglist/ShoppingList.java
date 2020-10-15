package objects.shoppinglist;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShoppingList {

	private String[] products = { "Kaffee", "Mate", "Pizza", "Nudeln", "Brot", "Käse", "Zahnpasta", "Deo", "Seife", "Shampoo" };
	private int[] repeat = { 10, 2, 1, 3, 3, 2, 28, 40, 22, 37 };
	private Calendar currentDate;
	private int dayCounter = 0;

	public ShoppingList() {
		currentDate = Calendar.getInstance();
	}

	public void nextDay() {
		//Note: Die Verwendung der Klasse Calendar ist optional und nur notwendig, wenn das aktuelle Datum gemerkt werden soll.
		int month = currentDate.get(Calendar.MONTH);
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int year = currentDate.get(Calendar.YEAR);

		if (day == 28 && month == Calendar.FEBRUARY) {
			month = Calendar.MARCH;
			day = 1;
		} else if((month == Calendar.APRIL || 
				month == Calendar.JUNE || 
				month == Calendar.SEPTEMBER ||
				month == Calendar.NOVEMBER) &&
				day == 30) {
			
			month++;
			day = 1;
		} else if((month == Calendar.JANUARY || 
				month == Calendar.MARCH || 
				month == Calendar.MAY || 
				month == Calendar.JULY || 
				month == Calendar.AUGUST || 
				month == Calendar.OCTOBER || 
				month == Calendar.DECEMBER) &&
				day == 31) {
			day = 1;
			month++;
		} else {
			day++;
		}
		dayCounter++;
		currentDate.set(year, month, day);
	}

	public String getCurrentProducts() {
		//Note: Die Verwendung der Klasse Calendar und SimpleDateFormat ist optional und nur notwendig, wenn das aktuelle Datum ausgegeben werden soll.	
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String msg = "Am " + sdf.format(currentDate.getTime()) + " stehen folgende Produkte auf der Einkaufsliste:\n";
		for (int day = 0; day < repeat.length; day++) {
			if(dayCounter % repeat[day] == 0) {
				msg += products[day] + "\n";
			}
		}
		return msg;
	}
	

}
