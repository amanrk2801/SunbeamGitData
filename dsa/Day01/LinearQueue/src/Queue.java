
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
			rear++;
			//2. add value at rear index
			arr[rear] = value;
		}
	}
	
	public int pop() {
		int temp = -1;
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			temp = arr[front + 1];
			//1. reposition front
			front++;
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
			temp = arr[front + 1];
		}
		return temp;
	}

	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return rear == SIZE-1;
	}
	
	
}













