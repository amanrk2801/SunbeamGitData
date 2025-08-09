import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 , num2 , ans; 
		String op; 
		System.out.print("num1 : ");
		num1 = sc.nextInt(); 
		System.out.print("num2 : ");
		num2 = sc.nextInt();
		do {
			System.out.println("Enter + , - , * , / or . exit");
			op = sc.next(); 
			switch (op) {
			case "+":
				ans = num1 + num2;
				System.out.println("ans : "+ans);
				break;
			case "-":
				ans = num1 - num2; 
				System.out.println("ans : "+ans);
				break;
			case "*":
				ans = num1 * num2; 
				System.out.println("ans : "+ans);
				break;
			case "/":
				ans = num1 / num2; 
				System.out.println("ans : "+ans);
				break;
			default:
				break;
			}
		} while (!op.equals("."));
	}
}
