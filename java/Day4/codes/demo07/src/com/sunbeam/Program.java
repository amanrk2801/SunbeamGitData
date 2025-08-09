package com.sunbeam;
class Test{
	private int num1; 
	private int num2; 
	private static int num3;
	static {
		num3 = 500;  
	}
	public Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public void display( ) {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : "+Test.num3);
	}
	
}
public class Program {
	public static void main(String[] args) {
		Test t1 = new Test(10, 20); 
		Test t2 = new Test(20, 30);
		Test t3 = new Test(40, 50);
		t1.display();
		t2.display();
		t3.display();
	}

}
