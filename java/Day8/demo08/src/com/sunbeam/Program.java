package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;

class Employee implements Comparable<Employee>{
	private int id; 
	private String name; 
	private double salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String toString() {
		return String.format("%-20d%-15s%10.2f",this.id,this.name,this.salary); 
	}
	@Override
	public int compareTo(Employee other) {
		return this.id - other.id; 
	}
	
}
class SortById implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		return x.getId() - y.getId(); 
	}
	
}
class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		return x.getName().compareTo(y.getName()); 
	}
}
class SortBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		return (int) (x.getSalary() - y.getSalary()); 
	}
	
}

public class Program {
	public static Employee[] getInstances( ) {
		Employee[] arr = new Employee[4]; 
		arr[0] = new Employee(3, "Rohan", 3000.00);
		arr[1] = new Employee(4, "Ketan", 2000.00);
		arr[2] = new Employee(1, "Aditya", 4000.00);
		arr[3] = new Employee(2, "Sagar", 1000.00);
		return arr; 
	}
	public static void print(Employee[] arr , Comparator<Employee> comparator) {
			Arrays.sort(arr, comparator);
			for(int i = 0 ; i < arr.length ; i++) {
				System.out.println(arr[i]);
			}
	}
	public static void main(String[] args) {
	     Employee[] arr = Program.getInstances(); 	
	     
	     //Program.print(arr, new SortById());
	       
	     //Program.print(arr, new SortByName());
	       
	    //Program.print(arr, new SortBySalary());
	      
	      Program.print(arr, null);
	      //A null value indicates that the elements' natural 
	      //ordering should be used.
	}

}
