package com.sunbeam;

public class Program {
	public static void main(String[] args) {
		//Person p = new Person(); 
		//p.display();
		
		//Person p2 = new Person("Aditya", 31); 
		//p2.display();
		
		//Student s = new Student(); 
		//s.display();
		
		Student s = new Student("Aditya", 31, 1, "MCS",78); 
		//s.display();
		System.out.println("Name : "+s.getName());
		System.out.println("Age : "+s.getAge());
		System.out.println("Roll : "+s.getRoll());
		System.out.println("Course : "+s.getCourse());
		System.out.println("Marks : "+s.getMarks());
	}
}






