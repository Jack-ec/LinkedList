
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
		String s = "[";
		Node current = head;
		while(current.next != null) {
			s = s + current.getValue() + ", ";
			current = current.next;
		}
		if (current != null) {
			s = s + current.getValue() + "]";
		}
		return s;
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
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		else {
		 Node current = head;
		 int pos = index;
		 for(int i = 0; i < pos; i++){  
				current = current.next;  
			}  
		 current.value = element;
		}
	}

	public void remove(int index) {
		if(head == null) {
			throw new IndexOutOfBoundsException();
		}
		else {  
			Node current = head;  

			int pos = index;  

			for(int i = 0; i < pos; i++){  
				current = current.next;  
			}  

			if(current == head) {  
				head = current.next;  
			}  
			else if(current == tail) {  
				tail = tail.previous;  
			}  
			else {  
				current.previous.next = current.next;  
				current.next.previous = current.previous;  
			}  
			current = null;  
		}  
		size--;
	}
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
}

