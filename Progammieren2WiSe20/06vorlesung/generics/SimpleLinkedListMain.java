package generics;

import java.util.LinkedList;

public class SimpleLinkedListMain {

	public static void main(String[] args) {
		
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		System.out.println(list.size());
		list.remove(0);
//		System.out.println(list.get(8));
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
