package objects.chat;

public class ChatMain {

	public static void main(String[] args) {
		
		Person user1 = new Person("Anton", "anton@gmx.de", "1234");
		Person user2 = new Person("Lara", "lara.schmidt@haw-hamburg.de", "DasPasswordErrätstDuNie!");
		Chat chat = new Chat(user1, user2);
		chat.sendMessage(user1, user2, "Hey, was geht?");
		chat.sendMessage(user1, user2, "Nachher zocken?");
		chat.sendMessage(user2, user1, "Jo, geht klar");
		chat.sendMessage(user1, user2, "20 Uhr?");
		chat.sendMessage(user2, user1, "Passt. Hast du schon Mike gefragt?");
		chat.sendMessage(user1, user2, "Nee, mach ich gleich mal.");
		chat.sendMessage(user2, user1, "Cool!");
		chat.sendMessage(user1, user2, "Bis nachher, Digga");
	
		for(Message message : chat.getMessages()) {
			if(message != null) {
				System.out.println(message);				
			}
		}
	}
	
}
