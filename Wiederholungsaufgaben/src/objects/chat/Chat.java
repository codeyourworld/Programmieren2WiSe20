package objects.chat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Chat {

		private static int CHAT_ID = 1000;
		private Person [] persons = new Person[2];
		private Message [] messages = new Message[100];
		private int numberMessages = 0;
		private int chatID = 0;
		
		public Chat(Person user1, Person user2) {
			chatID = CHAT_ID;
			CHAT_ID++;
			
			persons[0] = user1;
			persons[1] = user2;
		}
		
		
		public void sendMessage(Person sender, Person receiver, String msg) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			String date = sdf.format(Calendar.getInstance().getTime()).split(" ")[0];
			String time = sdf.format(Calendar.getInstance().getTime()).split(" ")[1];

			Message message = new Message(receiver, sender, msg, date, time);
			messages[numberMessages] = message;
			numberMessages++;			
		}
		
		public Message getLastMessage() {
			return messages[numberMessages];
		}
		
		public Message[] getMessages() {
			return messages;
		}
		
		public int getChatID() {
			return chatID;
		}
		
		public Person[] getPersons() {
			return persons;
		}
	}
