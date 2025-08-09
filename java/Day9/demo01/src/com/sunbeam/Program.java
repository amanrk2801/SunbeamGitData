package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;

class Person{
	private String name; 
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return String.format("%-15s",this.name); 
	}
}
class Employee extends Person{
	private int empid; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name , int empid) {
		super(name); 
		this.empid = empid;
	}
	public int getEmpid() {
		return empid;
	}
	@Override
	public String toString() {
		return String.format("%-20s%-15d",super.toString(),this.empid); 
	}
}
class Student extends Person{
	private int rollNo; 
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name , int rollNo) {
		super(name); 
		this.rollNo = rollNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	@Override
	public String toString() {
		return String.format("%-20s%-10d",super.toString(),this.rollNo); 
	}
}
class SortByName implements Comparator<Person>{

	@Override
	public int compare(Person x, Person y) {
		return x.getName().compareTo(y.getName()); 
	}
	
}
class SortByID implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		if(p1 instanceof Employee && p2 instanceof Employee) {
			Employee emp1 = (Employee) p1; 
			Employee emp2 = (Employee) p2;
			return emp1.getEmpid() - emp2.getEmpid(); 
		}
		else if(p1 instanceof Student && p2 instanceof Student) {
			Student s1 = (Student) p1; 
			Student s2 = (Student) p2;
			return s1.getRollNo() - s2.getRollNo(); 
		}
		else if(p1 instanceof Employee && p2 instanceof Student) {
			Employee emp1 = (Employee) p1; 
			Student s2 = (Student) p2; 
			return emp1.getEmpid() - s2.getRollNo(); 
		}
		else {
			Student s1 = (Student) p1; 
			Employee emp2 = (Employee) p2;
			return s1.getRollNo() - emp2.getEmpid(); 
		}
	}
	
}
public class Program {
	public static Person[] getInstances( ) {
		Person[] arr = new Person[4]; 
		arr[0] = new Employee("Aditya", 3); 
		arr[1] = new Student("Rahul", 2); 
		arr[2] = new Employee("Sagar", 1); 
		arr[3] = new Student("Kunal", 4);  
		return arr; 
	}
	public static void print(Person[] p) {
		for (Person p1 : p) {
			System.out.println(p1.toString());
		}
	}
	public static void main(String[] args) {
		Person[] arr = Program.getInstances(); 
		Arrays.sort(arr , new SortByID());
		Program.print(arr);
	}
	public static void main1(String[] args) {
		Person[] arr = Program.getInstances(); 
		Arrays.sort(arr , new SortByName());
		Program.print(arr);
	}

}
