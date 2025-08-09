package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
	private int empid; 
	private String name; 
	private double salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (empid != other.empid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%-20d%-15s%10.2f",this.empid,this.name,this.salary); 
	}
	
}
public class Program {
	private static List<Employee> empList = new ArrayList<Employee>( );
	private static Scanner sc = new Scanner(System.in);
	public static Employee[] getEmployees( ) {
		Employee[] arr = new Employee[5]; 
		arr[0] = new Employee(3, "Ketan", 2000.00);
		arr[1] = new Employee(2, "Aditya", 3000.00);
		arr[2] = new Employee(4, "Rohan", 5000.00);
		arr[3] = new Employee(5, "Sagar", 1000.00);
		arr[4] = new Employee(1, "Kunal", 4000.00);
		return arr; 
	}
	public static void addEmployees(Employee[] employees) {
		for (Employee e : employees) {
			empList.add(e); 
		} 
	}
	public static Employee findEmployee(int empid) {
		 Employee key = new Employee(); 
		 key.setEmpid(empid);
		 int index = empList.indexOf(key); 
		 if(index!=-1) {
			 return empList.get(index); 
		 }
		 return null; 
	}
	public static void acceptRecord(int[] empid) {
		System.out.println("Enter the empid : ");
		empid[0] = sc.nextInt(); 
	}
	public static void printRecord(Employee e) {
		if(e!=null) {
			System.out.println(e.toString());
		}
		else 
			System.out.println("Record not found");
	}
	public static boolean removeEmployee(int empid) {
		Employee key = new Employee();
		key.setEmpid(empid);
		if(empList.contains(key)) {
			empList.remove(key); 
			return true; 
		}
		return false; 
	}
	public static void printEmployees( ) {
		for (Employee e : empList) {
			System.out.println(e.toString());
		}
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Add Employees");
		System.out.println("2.Find Employee");
		System.out.println("3.Remove Employee");
		System.out.println("4.Print Employee");
		System.out.println("Enter the choice : ");
		return sc.nextInt(); 
	}
	public static void main(String[] args) {
		int[] empid = new int[1];
		int choice; 
		while((choice = menuList())!=0) {
			switch (choice) {
			case 1:
				empList.clear(); 
				Employee[] arr = Program.getEmployees(); 
				Program.addEmployees(arr);
				break;
			case 2: 	
				Program.acceptRecord(empid);
				Employee e = Program.findEmployee(empid[0]); 
				Program.printRecord(e);
				break; 
			case 3: 
				Program.acceptRecord(empid);
				boolean removedStatus = Program.removeEmployee(empid[0]); 
				System.out.println(removedStatus ? "Employee removed" : "Employee not found");
				break; 
			case 4: 
				Program.printEmployees();
				break; 
			default:
				System.out.println("Invalid choice");
				break;
			}
		}

	}

}


