package com.sunbeam;
/* final field can be initialized using field initializer, obj initializer, or constructor.
 * Once initialized, it cannot be modified again.
 * However, final fields must be initialized (in any of the above options). If not, compiler raise error.
 */ 

class Circle{
	private double radius; 
	private final double PI = 3.14;// field init 
	
	public Circle(double radius) {
		this.radius = radius;
	}
	{
		//PI = 3.14;// already init in field init  
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Circle() {
		//PI = 3.14; // already init in field init  
	}
	public double calcArea( ) {
		return PI * this.radius * this.radius; 
	}
	public double calcPeri( ) {
		return 2 * PI * this.radius; 
	}
}
public class Program {
	public static void main(String[] args) {
		final int a;  // final variable declaration 
		a = 10; // final var assignment 
		//a = 11; // once init cannot be modified 
		Circle c1 = new Circle(4.1); 
		//System.out.println("Area : "+c1.calcArea());
		//System.out.println("Peri : "+c1.calcPeri());
		double rad = 5.1; 
		final Circle c2 = new Circle(rad);//reference is final
		c2.setRadius(70); // object state can be modified 
		//c2 = null; // we cannot modify the reference 
		//System.out.println("Area : "+c2.calcArea());
		//System.out.println("Peri : "+c2.calcPeri());
		
		//int final x = 30; // NOT OK 
		  final int x = 40; 
	}
}




