package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Aditya", 1000.00); 
		Employee e2 = e1; // shallow copy of references  
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		
	}

}
