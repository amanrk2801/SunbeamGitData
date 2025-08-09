
public class List {
	static class Node{
		private char data;
		private Node next;
		private Node prev;
		public Node(char value) {
			data = value;
			next = prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int count;
	
	public List() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		//return count == 0;
		//return head == null;
		return head == null && tail == null;
	}
	
	public int size() {
		return count;
	}
	
	public void forward_display() {
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward List : ");
		while(trav != null) {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat till last node
		System.out.println("");
	}
	
	public void backward_display() {
		//1. create trav and start at last node
		Node trav = tail;
		System.out.print("Backward List : ");
		while(trav != null) {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat till last node
		System.out.println("");
	}
	
	public void addFirst(char value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			// add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
		count++;
	}
	
	public void addLast(char value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			//a. add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		count++;
	}
	
	public void addPosition(char value, int pos) {
		//0. validate the position 
		if(pos < 1 || pos > count + 1)
			return;
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			head = tail = newnode;
		// special case 1 : pos = 1
		else if(pos == 1) {
			addFirst(value);
			return;
		}
		// special case 2 : pos = count + 1
		else if(pos == count + 1) {
			addLast(value);
			return;
		}
		//3. if list is not empty
		else {
			// traverse till pos - 1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//a. add pos node into next of newnode
			newnode.next = trav.next;
			//b. add pos-1 node into prev of newnode
			newnode.prev = trav;
			//c. add newnode into prev of pos node
			trav.next.prev = newnode;
			//d. add newnode into next of pos-1 node
			trav.next = newnode;
		}
		count++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move head on second node
			head = head.next;
			//b. add null into prev of second node
			head.prev = null;
		}
		count--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move tail on second last node
			tail = tail.prev;
			//b. add null into next of second last node
			tail.next = null;
		}
		count--;
	}
	
	public void deletePosition(int pos) {
		//0. validate the position
		if(pos < 1 || pos > count)
			return;
		//1. if list is empty
		else if(head == null)
			return;
		// special case 1 : pos = 1
		else if(pos == 1) {
			deleteFirst();
			return;
		}
		// special case 2 : pos = count
		else if(pos == count) {
			deleteLast();
			return;
		}
		//2. if list is not empty
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of pos - 1 node
			trav.prev.next = trav.next;
			//c. add pos - 1 node into prev of pos + 1 node
			trav.next.prev = trav.prev;
		}
		count--;
	}
	
	public void deleteAll() {
		head = tail = null;
		count = 0;
	}
	
}












