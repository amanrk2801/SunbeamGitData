import java.util.Scanner;

class Employee{ 
	//fields 
	private int empid; // instance variable  
	private String name; // instance variable
	private double salary; // instance variable
	
	public void acceptRecord() { // instance method 
		Scanner sc = new Scanner(System.in);
		System.out.print("Empid : ");
		empid = sc.nextInt(); 
		System.out.print("Name : ");
		name = sc.next(); 
		System.out.println("Salary : ");
		salary = sc.nextDouble(); 
	}
	public void printRecord( ) {
		System.out.println("Empid : "+empid);
		System.out.println("Name : "+name);
		System.out.println("Salary : "+salary);
	}
} 

public class Program {
	public static void main(String[] args) {
		Employee emp1 = new Employee(); 
		Employee emp2 = new Employee(); 
		Employee emp3 = new Employee(); 
		//emp1 , emp2 , emp3 will space on java stack 
	}
	public static void main3(String[] args) {
		new Employee(); //Annonymous object / instance 
	}
	public static void main2(String[] args) {
		Employee emp; // Reference
		emp = new Employee(); // Instance 
		emp.acceptRecord();
		emp.printRecord();
	}
	public static void main1(String[] args) {
		Employee emp = new Employee();  
		//emp -> Object reference 
		// new Employee() -> Object instance 
		emp.acceptRecord();
		emp.printRecord();
		
	}
}
