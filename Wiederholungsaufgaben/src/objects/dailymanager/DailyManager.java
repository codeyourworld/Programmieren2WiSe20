package objects.dailymanager;

public class DailyManager {


	public static void main(String[] args) {
		Event[] events = {
				new Event("Kino", "20.10.2020", "15:30", Types.FRIENDS),
				new Event("Krimi Dinner", "17.11.2020", "20:00", Types.FRIENDS),
				new Event("HSV - St. Pauli", "30.10.2020", "15:30", Types.FAMILY),
				new Event("Halbmarathon", "01.11.2020", "13:00", Types.SPORT),
				new Event("Zocken", "19.10.2020", "21:00", Types.FRIENDS),
				new Event("Programmieren Tutorium", "19.10.2020", "16:30", Types.UNI),
				new Event("Programmieren Tutorium", "20.10.2020", "17:00", Types.UNI),
				new Event("Programmieren Tutorium", "28.10.2020", "16:30", Types.UNI),
				new Event("Programmieren Tutorium", "29.10.2020", "17:00", Types.UNI)
		};
		
		events[2].setPriority(Prio.HIGH);
		
		for(Event event : events) {
			System.out.println(event);
		}
		
	}
}
