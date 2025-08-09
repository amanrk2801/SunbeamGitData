package com.sunbeam;
class Outer{
	static int outerField1 = 10;
	int outerField2 = 20; 
	int field = 30;
	
	class Inner{
		final static int innerField1 = 40;
		int innerField2 = 50; 
		int field = 60;
		
		public void display( ) {
			 //System.out.println("outerField1 : "+outerField1); //10 
			 //System.out.println("outerField2 : "+outerField2); //20  
			 //System.out.println("Field : "+Outer.this.field); // 30 
			
			 //System.out.println("InnerField1 : "+innerField1);
			 //System.out.println("InnerField2 : "+innerField2);
			  System.out.println("Field : "+field);
		}
	}
}
public class Program {

	public static void main(String[] args) {
		Outer outer = new Outer(); // Outer class Object 
		Outer.Inner inObj = outer.new Inner();  // Inner Class Object 
		inObj.display();

	}

}
