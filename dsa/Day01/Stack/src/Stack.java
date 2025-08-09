
public class Stack {
	private int arr[];
	private int top;
	private final int SIZE;
	
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}
	
	public void push(int value) {
		if(isFull())
			System.out.println("Stack is full");
		else {
			//1. repoistion top
			top++;
			//2. add value at top index
			arr[top] = value;
		}
	}
	
	public int pop() {
		int temp = -1;
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			temp = arr[top];
			//1. reposition top
			top--;
		}
		return temp;
	}
	
	public int peek() {
		int temp = -1;
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			//1. read value of top index and return
			temp = arr[top];
		}
		return temp;
	}

	public boolean isFull() {
		return top == SIZE-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
}











