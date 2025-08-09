package com.sunbeam;

public class Employee extends Person {
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