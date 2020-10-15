package veryAdvanced.objects.studentplaner;

import java.util.ArrayList;
import java.util.Collections;

public class Timetable {

	private ArrayList<Lesson> lessons = new ArrayList<>();

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}
	
	public boolean addLession(Lesson lesson) {
		boolean success = false;
		if(!isCollided(lesson) && !lessons.contains(lesson)) {
			lessons.add(lesson);
			success = true;
//			System.out.println("successfully added " + lesson);
			Collections.sort(lessons);
		}
		return success;
	}

	private boolean isCollided(Lesson lesson) {
		for (Lesson tmp : lessons) {
			if(tmp.isOnline() || lesson.isOnline()) {
				System.out.println("one of the lession is online, so there is no collision");
				return false;
			}
 			if(tmp.getDay() == lesson.getDay() && tmp.getRoom() == lesson.getRoom()) {
// 				System.out.println("Days are the same and the rooms too");
// 				System.out.println(tmp.getStart().compareTo(lesson.getStart())<=0);
// 				System.out.println(calcEnd(tmp).compareTo(lesson.getStart())>0);
				if((tmp.getStart().compareTo(lesson.getStart()) <= 0 && calcEnd(tmp).compareTo(lesson.getStart()) > 0) || 
					(lesson.getStart().compareTo(tmp.getStart()) <= 0 && calcEnd(lesson).compareTo(tmp.getStart()) > 0)) 
				{
					System.err.println("Collision detected: " + tmp + " and " + lesson);
					return true;
				}

			}
		}
		
		return false;
	}

	private String calcEnd(Lesson tmp) {
		int tmpEndmin = Integer.valueOf(tmp.getStart().split(":")[1]) + Integer.valueOf(tmp.getDuration().split(":")[1]);
		int tmpEndhour = Integer.valueOf(tmp.getStart().split(":")[0]) + Integer.valueOf(tmp.getDuration().split(":")[0]) + tmpEndmin / 60;
		tmpEndmin %= 60;
		String tmpEnd = String.format("%02d:%02d", tmpEndhour, tmpEndmin);
		return tmpEnd;
	}
	
}
