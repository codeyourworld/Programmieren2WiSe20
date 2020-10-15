package objects.alarmclock;

public class AlarmClock {

	private String currentTime;
	private String alarmTime;
	private String message = "";
	private boolean isOn = false;
	
	public AlarmClock(String currentTime) {
		this.currentTime = currentTime;
	}

	public boolean isRingingNow() {
		return currentTime.equals(alarmTime);
	}
	
	
	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
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
		AlarmClock alarmClock = new AlarmClock("18:20");
		alarmClock.setAlarmTime("12:00");
		
		System.out.println("Die Weckzeit ist: " + alarmClock.getAlarmTime());
		System.out.println("Die aktuelle Uhrzeit ist: " + alarmClock.getCurrentTime());

		if(alarmClock.isRingingNow()) {
			System.out.println("Der Wecker klingelt");
		} else {
			System.out.println("Der Wecker klingelt nicht");
		}
	}
	
}
