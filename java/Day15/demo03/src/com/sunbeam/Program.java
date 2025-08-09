package com.sunbeam;
class Outer{
	static int outerField1 = 10;
	int outerField2 = 20; 
	static int field = 30;
	
	static class Inner{
		static int innerField1 = 40;
		int innerField2 = 50; 
		static int field = 60;
		
		public void display( ) {
			//System.out.println("outerField1 : "+outerField1); //10 
			//System.out.println("outerField2 : "+outerField2); // NOT OK 
			//System.out.println("Field : "+Outer.field); // 30 
			
			System.out.println("InnerField1 : "+innerField1);
			System.out.println("InnerField2 : "+innerField2);
			System.out.println("Field : "+field);
		}
	}
}
public class Program {

	public static void main(String[] args) {
		Outer.Inner inObj = new Outer.Inner(); 
		inObj.display();

	}

}
