import java.util.Scanner;

class Employee {
	// fields
	private int empid; // instance variable
	private String name; // instance variable
	private double salary; // instance variable

	// getter / inspectors
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	// setters / mutator
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

class EmployeeTest {
	Employee emp = new Employee(); 
	public void acceptRecord() { // instance method
		Scanner sc = new Scanner(System.in);
		System.out.print("Empid : ");
		emp.setEmpid(sc.nextInt());
		System.out.print("Name : ");
		emp.setName(sc.next());
		System.out.println("Salary : ");
		emp.setSalary(sc.nextDouble());
	}

	public void printRecord() {
		System.out.println("Empid : "+emp.getEmpid());
		System.out.println("Name : "+emp.getName());
		System.out.println("Salary : "+emp.getSalary());
		
	}
}

public class Program {

	public static void main(String[] args) {
		EmployeeTest employeeTest = new EmployeeTest(); 
		employeeTest.acceptRecord();
		employeeTest.printRecord();
	}

}
