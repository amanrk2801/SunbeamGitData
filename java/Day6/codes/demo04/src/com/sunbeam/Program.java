package com.sunbeam;

public class Program {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date dt1 = new Date(1, 1, 2001); 
		Date dt2 = (Date) dt1.clone(); 
		
		System.out.println("Dt1 : "+dt1.toString());
		System.out.println("Dt2 : "+dt2.toString());
	}

}
