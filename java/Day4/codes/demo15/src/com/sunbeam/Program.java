package com.sunbeam;

class Person {
	String name;
	int age;

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
	int empid;
	double salary;

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
		Person p = new Person("Aditya", 31); 
		Employee e =  (Employee) p; //classcast exception 
	}
	public static void main5(String[] args) {
		Person p = new Employee("Aditya", 31, 1, 1000.00); //upcasting 	
		System.out.println("Name : "+p.name);
		System.out.println("Age : "+p.age);
		Employee e = (Employee) p; //downcasting  
		System.out.println("Name : "+e.name); // OK 
		System.out.println("Age : "+e.age);// OK 
		System.out.println("Empid : "+e.empid);// OK 
		System.out.println("Salary : "+e.salary);//OK
	}
	public static void main4(String[] args) {
		Employee e = new Employee("Aditya", 31, 1, 1000.00);
		System.out.println("Name : "+e.name); // OK 
		System.out.println("Age : "+e.age);// OK 
		System.out.println("Empid : "+e.empid);// OK 
		System.out.println("Salary : "+e.salary);//OK
		Person p = e; // upcasting  
		System.out.println("Name : "+p.name);// OK 
		System.out.println("Age : "+p.age); // OK 
		e = (Employee) p;
		System.out.println("Name : "+e.name); // OK 
		System.out.println("Age : "+e.age);// OK 
		System.out.println("Empid : "+e.empid);// OK 
		System.out.println("Salary : "+e.salary);//OK
	}
	public static void main3(String[] args) {
		Employee e = new Employee("Aditya", 31, 1, 1000.00);
		System.out.println("Name : "+e.name); // OK 
		System.out.println("Age : "+e.age);// OK 
		System.out.println("Empid : "+e.empid);// OK 
		System.out.println("Salary : "+e.salary);//OK 
		Person p = (Person)e;// upcasting  
		System.out.println("Name : "+p.name);
		System.out.println("Age : "+p.age);
		//System.out.println("Empid : "+p.empid);
		//System.out.println("Salary : "+p.salary);
		
		
		
	}
	public static void main2(String[] args) {
		//Employee e1 = new Employee(); 
		//e1.printRecord();
		Employee e1 = new Employee("Aditya", 31, 1, 1000.00); 
		System.out.println("Name : "+e1.name);
		System.out.println("Age : "+e1.age);
		System.out.println("Empid : "+e1.empid);
		System.out.println("Salary : "+e1.salary);
	}
	public static void main1(String[] args) {
		//Person p = new Person(); 
		//p.showRecord();
		Person p = new Person("Aditya", 31); 
		p.showRecord();
	}

}
