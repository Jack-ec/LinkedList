
public class LinkedList {
	private Node base;
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
		if (tail == null) {
			return;
		}
		Node new_node = new Node(element, tail, head);
		new_node.next = tail.next;
		tail.next = new_node;
		new_node.previous = tail;
		if (new_node.next != null) {
			new_node.next = new_node;
			new_node.previous = new_node;
		}
	}

	public String toString() {
		
	}

	public int size() {
		int count = 0;
	    if (base == null)
	        return count;
	    else {
	        Node temp = base;
	        do {
	            temp = temp.next;
	            count++;
	        } while (temp != base);
	    }
	    return count;
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
