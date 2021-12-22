import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList implements ListIterator<String>{
	Node head = null;
	Node tail = null;
	int size = 0;
	Node cursor = null;
	Node lastAccessed = null;
	int index = 0;
	boolean lastCallWasNext = false;
	boolean lastCallWasPrevious = false;
	boolean lastCallWasAdd = false;
	boolean lastCallWasRemove = false;
	
	public void addAtEnd(String element) {
		Node newNode = new Node(element, null, null);  
		if(head == null) {   
			head = tail = cursor = newNode;
			cursor.previous = lastAccessed;
			head.previous = null;  
			tail.next = null;  
		}  
		else {  
			tail.next = newNode;  
			newNode.previous = tail;  
			tail = newNode;  
		}  
		size++;
	}

	public void add(int index, String element) {
		if (index < 0|| index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node newNode = new Node(element, null, null);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else if (index == 0) {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		else if (index == size) {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
		}
		else {
			Node nodeRef = head;
			for (int i = 1; i < index; i++) {
				nodeRef = nodeRef.next;
			}
			newNode.next = nodeRef.next;
			nodeRef.next = newNode;
			newNode.previous = nodeRef;
			newNode.next.previous = newNode;
		}
		size++;
	}

	public String toString() {
		String string = "[";
		for (Node node = this.head; node != null; node = node.next) {
			if (node.next == null) {
				string = string + node.value;
			}
			else {
				string = string + node.value +", ";
			}
		}
		string = string + "]";
		return string;
	}


	public int size() {
		return size;

	}
	private Node getNode(int index) {
		Node current = this.head;

		if (index >= 0 && index <= this.size) {
			int i = 0;

			while( current != null && i++ < index) {
				current = current.next;
			}
		}
		else {
			current = null;
		}

		return current;
	}

	public String get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.value;
		}
	}
	public void set(int index, String element) {
		Node current = getNode(index);
		current.value = element;
	}

	public void remove(int index) {
		Node current = getNode(index);
		Node prev = current.previous;
		Node next = current.next;

		if (current.next == null && current.previous == null) {
			current = null;
		}

		else if (current.next == null) {
			current = null;
			prev.next = null;
		}

		else if (current.previous == null) {
			current = null;
			next.previous = null;
			head = next;
		}

		else {
			current = null;
			prev.next = next;
			next.previous = prev;
		}
		this.size--;
	}

	public void clear() {
		head = null;
		size = 0;
	}


	@Override
	public boolean hasNext() {
		if (cursor != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String next() {
		String value = "";
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		else {
			lastAccessed = cursor;
			value = cursor.value;
			index++;
		}
		lastCallWasNext = true;
		lastCallWasPrevious = false;
		lastCallWasAdd = false;
		lastCallWasRemove = false;
		cursor = cursor.next;
		return value;
	}

	@Override
	public boolean hasPrevious() {
		if (lastAccessed != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String previous() {
		String value = "";
		if (!hasPrevious()) {
			throw new NoSuchElementException();
		}
		else if (lastCallWasAdd == true) {
			index--;
			lastCallWasNext = false;
			lastCallWasPrevious = true;
			lastCallWasAdd = false;
			lastCallWasRemove = false;
			return lastAccessed.next.value;
		}
		else {
			value = lastAccessed.value;
			index --;
			cursor = lastAccessed;
			lastAccessed = cursor.previous;
			lastCallWasNext = false;
			lastCallWasPrevious = true;
			lastCallWasAdd = false;
			lastCallWasRemove = false;
			return value;
		}
	}

	@Override
	public int nextIndex() {
		return index;
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		if (lastAccessed == null) throw new IllegalStateException();
		Node x = lastAccessed.previous;
		Node y = lastAccessed.next;
		x.next = y;
		y.previous = x;
		size--;
		if (cursor == lastAccessed)
			cursor = y;
		else {
			index--;
		}
		lastAccessed = null;
		lastCallWasNext = false;
		lastCallWasPrevious = false;
		lastCallWasAdd = false;
		lastCallWasRemove = true;
	}

	@Override
	public void set(String e) {
		if (lastCallWasAdd == true || lastCallWasRemove == true) {
			throw new IllegalStateException();
		}
		else if (lastCallWasNext == true) {
			set(previousIndex(), e);
			lastCallWasNext = false;
			lastCallWasPrevious = false;
			lastCallWasAdd = false;
			lastCallWasRemove = false;
		}
		else if (lastCallWasNext == false) {
			set(nextIndex(), e);
			lastCallWasNext = false;
			lastCallWasPrevious = false;
			lastCallWasAdd = false;
			lastCallWasRemove = false;
		}
	}
	@Override
	public void add(String e) {
		if (lastCallWasNext == true && lastCallWasPrevious == false) {
			add(index, e);
			index++;
		}
		else if (lastCallWasPrevious == true && lastCallWasNext == false) {
			add(index, e);
			index++;
		}
		else {
			addAtEnd(e);
		}
		lastCallWasAdd = true;
		}

public ListIterator listIterator() {
	return this;
}
}
