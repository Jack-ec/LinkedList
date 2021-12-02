
public class LinkedList {
	Node head = null;
	Node tail = null;
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
            tail = newNode;  
            tail.next = null;  
        }  
	}

	public void add(int index, String element) {
		
	}

	public String toString() {
		
	}

	public int size() {
	}

	public void clear() {
		
	}

	public String get(int index) {
		
	}

	public void set(int index, String element) {
		
	}

	public void remove(int index) {
		
	}

}
