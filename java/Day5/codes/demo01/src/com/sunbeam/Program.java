package com.sunbeam;

class A{
	public void showRecord( ) {
		System.out.println("A.showRecord");
	}
	public void printRecord( ) {
		System.out.println("A.printRecord");
	}
	
	
	
	
}
class B extends A{
	
	public void printRecord( ) {
		System.out.println("B.printRecord");
	}
	public void displayRecord( ) {
		System.out.println("B.displayRecord");
	}
	
}



public class Program {
	public static void main(String[] args) {
		A ref = new B( );	//Upcasting
		
		//ref.showRecord(); 	//A.showRecord
		//ref.printRecord();	//B.printRecord	//Dynamic method dispatch
		//ref.displayRecord();	//Compiler Error
		//B b = (B) ref;	//Downcasting
		//b.displayRecord();		//B.displayRecord
	}
	public static void main2(String[] args) {
		B ref = new B( );
		ref.showRecord();		//A.showRecord
		ref.printRecord(); 		//B.printRecord
		ref.displayRecord();	//B.displayRecord
	}
	public static void main1(String[] args) {
		A ref = new A( );
		ref.showRecord();	//A.showRecord
		ref.printRecord();	//A.printRecord
		//ref.displayRecord( );	//Compiler error 
	}
}



