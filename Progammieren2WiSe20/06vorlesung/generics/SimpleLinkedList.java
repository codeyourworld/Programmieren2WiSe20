package generics;

import java.lang.reflect.InaccessibleObjectException;

public class SimpleLinkedList<T> {

	private int size;
	private Element<T> first;
	private Element<T> last;
	
	public void add(T data) {
		Element<T> current = new Element<T>(data);
		if(size == 0) {
			first = current;
			last = current;
		} else {
			current.setPrev(last);
			last.setNext(current);
			last = current;
		}
		
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Der Index " + index + " ist kleiner als 0 oder größer gleich " + size);
		}

		Element<T> current = first;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		return current.getCurrent();
	}
	
//	public T get(int index) throws IndexOutOfBoundsException {
//		
//		if(index < 0 || index >= size) {
//			throw new IndexOutOfBoundsException("Der Index " + index + " ist kleiner als 0 oder größer gleich " + size);
//		}
//
//		return get(index, first);
//	}
//		
//	public T get(int index, Element<T> current) {
//		
//		if(index == 0) {
//			return current.getCurrent();
//		} 
//
//		return get(index - 1, current.getNext());		
//	}
	
	
}
