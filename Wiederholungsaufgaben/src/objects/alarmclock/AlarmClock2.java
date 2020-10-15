package objects.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmClock2 {

	private Calendar currentTime;
	private Calendar alarmTime;
	private String message = "";
	private boolean isOn = false;
	
	public AlarmClock2() {
		currentTime = Calendar.getInstance();
	}

	public boolean isRingingNow() {
		currentTime.set(Calendar.SECOND, 0); 
		currentTime.set(Calendar.MILLISECOND, 0); 
		alarmTime.set(Calendar.SECOND, 0); 
		alarmTime.set(Calendar.MILLISECOND, 0); 
		return currentTime.equals(alarmTime);
	}
	
	public Calendar getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Calendar currentTime) {
		this.currentTime = currentTime;
	}

	public Calendar getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Calendar alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		AlarmClock2 alarmClock = new AlarmClock2();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 6);
		calendar.set(Calendar.MINUTE, 0);
		alarmClock.setAlarmTime(calendar);
		
		System.out.println("Die Weckzeit ist: " + sdf.format(alarmClock.getAlarmTime().getTime()));
		System.out.println("Die aktuelle Uhrzeit ist: " + sdf.format(alarmClock.getCurrentTime().getTime()));
		if(alarmClock.isRingingNow()) {
			System.out.println("Der Wecker klingelt");
		} else {
			System.out.println("Der Wecker klingelt nicht");
		}
	}
	
}
