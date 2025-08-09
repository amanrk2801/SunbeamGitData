import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		Stack st = new Stack(4);
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter data to be inserted : ");
				int data = sc.nextInt();
				st.push(data);
				break;
			case 2:
				System.out.println("Poped data : " + st.pop());
				break;
			case 3:
				System.out.println("Peeked data : " + st.peek());
				break;
			}
		}while(choice != 0);

		sc.close();
	}

}












