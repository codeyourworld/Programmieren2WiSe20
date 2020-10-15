package veryAdvanced.objects.studentplaner;

import java.util.ArrayList;

public class Lesson implements Comparable<Lesson> {

	public static final String [] DAYS = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
	private String name;
	private Lecturer lecturer;
	private ArrayList<Student> students = new ArrayList<>();
	private Room room;
	private String notes;
	private int day;
	private String start;
	private String duration;
	private boolean online;
	private String toolLink;

	public Lesson(String name, Lecturer lecturer, Room room, int day, String start, String duration) {
		this.name = name;
		this.lecturer = lecturer;
		this.room = room;
		this.day = day;
		this.start = start;
		this.duration = duration;
	}

	public Lesson(String name, Lecturer lecturer, Room room, int day, String start, String duration, boolean online) {
		this(name, lecturer, room, day, start, duration);
		this.online = online;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((lecturer == null) ? 0 : lecturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (day != other.day)
			return false;
		if (lecturer == null) {
			if (other.lecturer != null)
				return false;
		} else if (!lecturer.equals(other.lecturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getToolLink() {
		return toolLink;
	}

	public void setToolLink(String toolLink) {
		this.toolLink = toolLink;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int compareTo(Lesson other) {
		if (day == other.day) {
			return start.compareTo(other.start);
		} 
		return day < other.day ? -1 : 1;
	}

	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		String output = DAYS[day] + "\n" + start + " (" +  duration + ")\n" + name + " (" + lecturer + ") in " + room;
		return output;
	}
	
	
}
