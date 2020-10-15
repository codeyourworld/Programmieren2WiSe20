package objects.chat;

public class Message {

	private Person receiver;
	private Person sender;
	private String message = "";
	private String time = "Unknown";
	private String date = "Unknown";
	private boolean isReceived = false;
	private boolean isRead = false;

	public Message(Person receiver, Person sender, String message, String time, String date) {
		this(receiver, sender, message);
		this.time = time;
		this.date = date;
	}

	public Message(Person receiver, Person sender, String message) {
		super();
		this.receiver = receiver;
		this.sender = sender;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isReceived() {
		return isReceived;
	}

	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return sender.getName() + ":\n\"" + message + "\"\n";
	}
	
}
