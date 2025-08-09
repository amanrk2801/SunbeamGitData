package com.sunbeam;

public class Program {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Person p1 = new Person("Aditya", 170, 78, new Date(1, 1, 2000)); 
		Person p2 = (Person) p1.clone(); 
		
		p2.getBirth().setDay(28);
		p2.getBirth().setMonth(3);
		p2.getBirth().setYear(2025);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	
		
	}

}
