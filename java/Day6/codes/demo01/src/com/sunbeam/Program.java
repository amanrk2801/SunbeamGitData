package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Aditya", 1000.00); 
		Employee e2 = new Employee(1, "Aditya", 1000.00); 
		
		boolean flag = e1 == e2; 
		//System.out.println("Res : "+flag);
		
		flag = e1.equals(e2); 
		//System.out.println("Res : "+flag);
		
		// this = e1; 
		//flag = e1.equals(e2);
		//System.out.println("Res : "+flag);
		
		//flag = e1.equals(null); 
		//System.out.println("Res : "+flag);
		
		flag = e1.equals(e1);
		//System.out.println("Res : "+flag);
		
		flag = e1.equals("e2");
		System.out.println("Res : "+flag);
	}

}
