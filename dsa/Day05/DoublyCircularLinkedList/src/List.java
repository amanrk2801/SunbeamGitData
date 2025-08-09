
public class List {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int value) {
			data = value;
			next = prev = null;
		}
	}
	
	private Node head;
	public List() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create a newnode
		Node nn = new Node(value);
		//2. if empty
		if(head == null) {
			//a. add newnode into head
			head = nn;
			//b. make list circular
			nn.prev = nn.next = nn;
		}
		//3. if not empty
		else {
			//a. add first node into next if newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
			//e. move head on newnode
			head = nn;
		}
	}
	
	public void addLast(int value) {
		//1. create a newnode
		Node nn = new Node(value);
		//2. if empty
		if(head == null) {
			//a. add newnode into head
			head = nn;
			//b. make list circular
			nn.prev = nn.next = nn;
		}
		//3. if not empty
		else {
			//a. add first node into next if newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
		}
	}
	
	public void deleteFirst() {
		//1. if empty
		if(head == null)
			return;
		//2. if single node
		if(head.next == head)
			head = null;
		//3. if multiple nodes
		else {
			//a. add second node into next of last node
			head.prev.next = head.next;
			//b. add last node into prev of second node
			head.next.prev = head.prev;
			//c. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if empty
		if(head == null)
			return;
		//2. if single node
		if(head.next == head)
			head = null;
		//3. if multiple nodes
		else {
			//a. add first node into next of second last node
			head.prev.prev.next = head;
			//b. add second last node into prev of first node
			head.prev = head.prev.prev;
		}
	}
	
	public void fDisplay() {
		if(head == null)
			return;
		Node trav = head;
		System.out.print("Forward List : ");
		do {
			System.out.print(" " + trav.data);
			trav = trav.next;
		}while(trav != head);
		System.out.println("");
	}
	
	public void rDisplay() {
		if(head == null)
			return;
		Node trav = head.prev;
		System.out.print("Reverse List : ");
		do {
			System.out.print(" " + trav.data);
			trav = trav.prev;
		}while(trav != head.prev);
		System.out.println("");
	}
	
	public void deleteAll() {
		head = null;
	}
}









