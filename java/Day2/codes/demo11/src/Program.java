import java.util.Scanner;

class Employee{ 
	//fields 
	private int empid; // instance variable  
	private String name; // instance variable
	private double salary; // instance variable
	
	//setter / mutator 
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//this = emp1 
	public void acceptRecord() { // instance method 
		Scanner sc = new Scanner(System.in);
		System.out.print("Empid : ");
		this.empid = sc.nextInt(); 
		System.out.print("Name : ");
		this.name = sc.next(); 
		System.out.print("Salary : ");
		this.salary = sc.nextDouble(); 
	}
	// this = emp 
	public void printRecord( ) {
		System.out.println("Empid : "+this.empid);
		System.out.println("Name : "+this.name);
		System.out.println("Salary : "+this.salary);
	}
} 

public class Program {
	public static void main(String[] args) {
		Employee emp = new Employee(); 
		emp.acceptRecord();  // emp.acceptRecord(emp); 
		emp.printRecord(); // emp.printRecord(emp);
		emp.setSalary(10000.00);  //emp.setSalary(emp , 10000.00);
		emp.printRecord();// emp.printRecord(emp);
	}
	public static void main1(String[] args) {
		Employee emp = new Employee(); 
		emp.acceptRecord();//emp.acceptRecord(emp);
		emp.printRecord();//emp.printRecord(emp);
		//emp.salary = 10000.00; // private  not accessible outside the class  
		System.out.println("updated  Salary : ");
		emp.printRecord();
		//emp.salary = 0.0; 
		emp.printRecord();
	}
	
}
