
public class List {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public List() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create a newnode
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = nn;
			//b. make list circular
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into next of last node
			tail.next = nn;
			//c. move head on newnode
			head = nn;
		}
	}
	
	public void addLast(int value) {
		//1. create a newnode
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = nn;
			//b. make list circular
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into next of last node
			tail.next = nn;
			//c. move tail on newnode
			tail = nn;
		}
	}
	
	public void deleteFirst() {
		//1. if list empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			tail.next = head.next;
			//b. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if list empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next != tail)
				trav = trav.next;
			//b. add first node into next of second last node
			trav.next = head;
			//c. move tail second last node
			tail = trav;
		}
	}
	
	public void display() {
		//0 if list is empty
		if(head == null)
			return;
		//1. create trav and start at head
		Node trav = head;
		do {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);	// 4. repeat till last node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = tail = null;
	}
	
}












