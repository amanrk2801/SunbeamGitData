import java.util.Scanner;

public class LinearQueueMain {

	public static void main(String[] args) {

		Queue q = new Queue(4);
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter value to be pushed");
				int value = sc.nextInt();
				q.push(value);
				break;
			case 2:
				System.out.println("Poped value : " + q.pop());
				break;
			case 3:
				System.out.println("Peeked value : " + q.peek());
				break;
			}
		}while(choice != 0);
		
		
		sc.close();
	}

}







