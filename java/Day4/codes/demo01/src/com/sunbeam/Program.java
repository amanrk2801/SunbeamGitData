package com.sunbeam;

class MyClass{
	private int num1 = 10; // field init  
	private int num2 = 20; // field init
	private int num3; 
	private int num4; 
	{
		this.num3 = 30; // object init / instance init ( java 5.0) 
		System.out.println("init block --- 1");
	}
	{
		this.num4 = 40; // object init / instance init ( java 5.0) 
		System.out.println("init block --- 2");
	}
	{
		System.out.println("init block -- 3");
	}
	public MyClass() {
		this.num1 = 60;
		this.num3 = 70;
		System.out.println("Constructor");
	}
	public void display( ) {
		System.out.printf("num1 : %d\nnum2 : %d\nnum3 : %d\nnum4 : %d\n",this.num1,this.num2,this.num3,this.num4);
	}
}
public class Program {
	public static void main(String[] args) {
		MyClass obj = new MyClass(); 
		obj.display();
		
	}
}




