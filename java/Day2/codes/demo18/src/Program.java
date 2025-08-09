

class Employee{
	private int empid; 
	private String name; 
	private double salary;
	
	
	public Employee() {
//		this.empid = 0; 
//		this.name = ""; 
//		this.salary = 0.0; 
		this(1, "Aditya", 10000.00); //constructro chaining 
	}
	
	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
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
public class Program {
	public static void main(String[] args) {
		Employee emp1 = new Employee( ); 
	}
	
}
