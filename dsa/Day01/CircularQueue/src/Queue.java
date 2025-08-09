
public class Queue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public Queue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void push(int value) {
		if(isFull())
			System.out.println("Queue is full");
		else {
			//1. reposition rear
			rear = (rear + 1) % SIZE;
			//2. add value at rear index
			arr[rear] = value;
		}
	}
	
	public int pop() {
		int temp = -1;
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			temp = arr[(front + 1)%SIZE];
			//1. reposition front
			front = (front + 1) % SIZE;
			if(front == rear)
				front = rear = -1;
		}
		return temp;
	}
	
	public int peek() {
		int temp = -1;
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			//1. read data of front + 1 index
			temp = arr[(front + 1) % SIZE];
		}
		return temp;
	}

	public boolean isEmpty() {
		return front == rear && rear == -1;
	}
	
	public boolean isFull() {
		return (front == -1 && rear == SIZE-1) || (front == rear && rear != -1);
	}
	
	
}













