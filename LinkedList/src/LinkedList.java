
public class LinkedList {
	Node head = null;
	Node tail = null;
	int size = 0;
	public void add(String element) {
		Node newNode = new Node(element, null, null);  
		if(head == null) {   
			head = tail = newNode;  
			head.previous = null;  
			tail.next = null;  
		}  
		else {  
			tail.next = newNode;  
			newNode.previous = tail;  
			tail = newNode.previous;  
			tail.next = null;  
		}  
		size++;
	}

	public void add(int index, String element) {
		if (index < 0|| index > size) {
			throw new IndexOutOfBoundsException();
		}
		

	}

	public String toString() {
		return " ";
	}


	public int size() {
		return size;

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

	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			head = head.next;
			head.previous = null;
			size--;
		} else if (index == size - 1) {
			tail = tail.previous;
			tail.next = null;
			size--;
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node previous = current.previous;
			Node next = current.next;
			previous.next = current.next;
			next.previous = previous;
			size--;
		}
	}
	public void clear() {
		 Node temp = new Node(null, null, null);
		  while(this.head != null) {
		    temp = this.head;
		    this.head = this.head.next;
		    temp = null;
		  }

	}


}
