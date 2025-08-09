package com.sunbeam;
class Person{
	String name; 
	int age; 
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void showRecord( ) {
		System.out.println("Name : "+this.name);
		System.out.println("Age : "+this.age); 
	}
	
}
class Employee{
	private String name; 
	private int age; 
	private int empid; 
	private double salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int age, int empid, double salary) {
		this.name = name;
		this.age = age;
		this.empid = empid;
		this.salary = salary;
	}
	public void printRecord( ) {
		System.out.println("Name : "+this.name);
		System.out.println("Age : "+this.age);
		System.out.println("Empid : "+this.empid);
		System.out.println("Salary : "+this.salary);
	}
	
}
public class Program {

	public static void main(String[] args) {
		//Employee e = new Employee(); 
		//e.printRecord();
		Employee e = new Employee("Aditya", 31, 1, 1000.00); 
		e.printRecord();
	}
	public static void main1(String[] args) {
		//Person p = new Person(); 
		//p.showRecord();
		Person p = new Person("Aditya", 31); 
		p.showRecord();
		
	}

}
