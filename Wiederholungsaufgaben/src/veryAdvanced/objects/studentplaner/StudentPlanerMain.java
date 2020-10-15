package veryAdvanced.objects.studentplaner;

public class StudentPlanerMain {

	public static void main(String[] args) {
		Timetable timetable = new Timetable();
		Lesson lesson = new Lesson("Programmieren 2", new Lecturer("Stephanie", "Böhning", "12312"), Room.E62, 4, "08:30", "03:30");
		timetable.addLession(lesson);
		lesson = new Lesson("Programmieren 1", new Lecturer("Larissa", "Putzar", "27621"), Room.E62, 1, "08:30", "03:30");
		timetable.addLession(lesson);
		timetable.addLession(new Lesson("Informatik 3", new Lecturer("Michael", "Berens", "12322"), Room.E63, 2, "08:30", "03:30"));
		timetable.addLession(new Lesson("Informatik 2", new Lecturer("Nils", "Martini", "234222"), Room.E64, 0, "08:30", "03:30"));
		timetable.addLession(new Lesson("Storage Management", new Lecturer("Nils", "Martini", "234222"), Room.E64, 0, "13:00", "03:30"));
		
		
		for (Lesson l : timetable.getLessons()) {
			System.out.println(l + "\n");
		}
	}
}
