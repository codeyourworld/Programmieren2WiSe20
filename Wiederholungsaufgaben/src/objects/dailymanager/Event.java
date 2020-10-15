package objects.dailymanager;

public class Event {

	private String eventName;
	private String date;
	private String time;
	private Prio priority = Prio.MIDDLE;
	private Types type;

	
	public Event(String eventName, String date, String time) {
		this(eventName, date, time, Types.OTHER);
	}

	public Event(String eventName, String date, String time, Types type) {
		this.eventName = eventName;
		this.date = date;
		this.time = time;
		this.type = type;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Prio getPriority() {
		return priority;
	}

	public void setPriority(Prio priority) {
		this.priority = priority;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\n" + eventName + 
				"\n" + date + " " + time + 
				"\npriority: " + priority + 
				"\nType: " + type + "\n";
	}

	
}
