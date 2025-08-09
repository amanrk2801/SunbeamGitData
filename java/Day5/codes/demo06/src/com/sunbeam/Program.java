package com.sunbeam;
final class Time{
	private int hrs; 
	private int mins;
	private int secs;
	// final classes cannot be inherited into any sub-class.
	// "effectively" all methods in final class become final.
	public void display( ) {
		System.out.println("hrs : "+this.hrs);
		System.out.println("mins : "+this.mins);
		System.out.println("secs : "+this.secs);
	}
}
/* 
class GoodTime extends Time{
	//TODO  
}*/ 
public class Program {

	public static void main(String[] args) {
		

	}

}
