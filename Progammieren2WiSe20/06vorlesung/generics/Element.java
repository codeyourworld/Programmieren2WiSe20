package generics;

public class Element<T> {

	private T current;
	private Element<T> next;
	private Element<T> prev;

	public Element(T current) {
		super();
		this.current = current;
	}

	public T getCurrent() {
		return current;
	}

	public void setCurrent(T current) {
		this.current = current;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	public Element<T> getPrev() {
		return prev;
	}

	public void setPrev(Element<T> prev) {
		this.prev = prev;
	}
	
	
	
}
