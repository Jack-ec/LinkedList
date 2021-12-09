
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
		Node temp = new Node(null, null, null);

		while(this.head != null) {
			temp = this.head;
			this.head = this.head.next;
			temp = null;
		}

		size = 0;
	}
}

