import java.util.Scanner;
public class Program {
	
	/* 
	public static void main(String[] args) {
		//(user-name , roll , marks)
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the name : ");
		String name = sc.next(); // name 
		System.out.print("Enter the roll : ");
		int roll = sc.nextInt(); 
		System.out.print("Enter the marks : ");
		double marks = sc.nextDouble(); 
		
		System.out.println("Name : "+name);
		System.out.println("Roll : "+roll);
		System.out.println("Marks : "+marks);
	}*/ 
	/* 
	public static void main(String[] args) {
		//(user-name , roll , marks)
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the name : ");
		String name = sc.nextLine();  
		System.out.print("Enter the roll : ");
		int roll = sc.nextInt(); 
		System.out.print("Enter the marks : ");
		double marks = sc.nextDouble(); 
		
		System.out.println("Name : "+name);
		System.out.println("Roll : "+roll);
		System.out.println("Marks : "+marks);
	}*/ 
	public static void main(String[] args) {
		//(user-name , roll , marks)
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the roll : ");
		int roll = sc.nextInt(); 
		System.out.print("Enter the name : ");
		sc.nextLine(); 
		String name = sc.nextLine();  
		System.out.print("Enter the marks : ");
		double marks = sc.nextDouble(); 
		
		System.out.println("Name : "+name);
		System.out.println("Roll : "+roll);
		System.out.println("Marks : "+marks);
	}

}
