package com.sunbeam;



public class Program {
	static int number = 10; // OK 
	public static void print( ) {
		number = number + 1; 
		System.out.println("num : "+number);
	}
	public static void main(String[] args) {
		//static int number = 10; // should be there inside classscope 
		Program.print();
		Program.print();
		Program.print();
		
	}
}
