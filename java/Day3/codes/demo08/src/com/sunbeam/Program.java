package com.sunbeam;

import java.util.Scanner;
class Employee{
	private int empid; 
	private String name; 
	private double salary; 
	public Employee() {
		this(1, "rohit", 1000.00); 
	}
	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	public void display( ) {
		System.out.printf("Empid : %d\nName : %s\nSalary : %.2f\n",this.empid,this.name,this.salary);
	}
	
}
public class Program {
	public static Employee[] getInstances( ) {
		Employee[] arr = new Employee[3]; 
		arr[0] = new Employee(3, "Aditya", 1000.00); 
		arr[1] = new Employee(2, "Amit", 2000.00); 
		arr[2] = new Employee(1, "Sagar", 3000.00);
		return arr; 
	}
	public static void printEmployees(Employee[] arr) {
		if(arr!=null) {
			for(Employee e : arr)
				e.display();
		}	
	}
	public static void main4(String[] args) {
		Employee[] arr = Program.getInstances(); 
		Program.printEmployees(arr);
	}
	public static void main3(String[] args) {
		Employee[] arr = new Employee[3]; 
		arr[0] = new Employee(3, "Aditya", 1000.00); 
		arr[1] = new Employee(2, "Amit", 2000.00); 
		arr[2] = new Employee(1, "Sagar", 3000.00);
		for(Employee e : arr) {
			e.display();
		}
	 
	}
	public static void main2(String[] args) {
		Employee[] arr = new Employee[] {new Employee(), new Employee(), new Employee()};   
		for(int i = 0 ; i < arr.length ; i++)
			arr[i].display();
	}
	public static void main(String[] args) {
		Employee[] arr = null; // reference 
		arr = new Employee[3]; 
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		for(int i = 0 ; i < arr.length ; i++)
			arr[i].display();
	}

}



