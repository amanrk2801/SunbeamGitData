package com.sunbeam;

class Person {
	private String name;
	private int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showRecord() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
	}

}

class Employee extends Person {
	// private String name;
	// private int age;
	private int empid;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, int empid, double salary) {
		super(name, age);
		this.empid = empid;
		this.salary = salary;
	}

	public void printRecord() {
		super.showRecord();
		System.out.println("Empid : " + this.empid);
		System.out.println("Salary : " + this.salary);
	}

}

public class Program {

	public static void main(String[] args) {
		//Employee e1 = new Employee(); 
		//e1.printRecord();
		Employee e1 = new Employee("Aditya", 31, 1, 1000.00); 
		e1.printRecord();
	}
	public static void main1(String[] args) {
		//Person p = new Person(); 
		//p.showRecord();
		Person p = new Person("Aditya", 31); 
		p.showRecord();
	}

}
