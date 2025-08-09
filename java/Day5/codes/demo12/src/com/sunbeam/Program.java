package com.sunbeam;

public class Program{
	public static void main(String[] args) {
		Shape r = new Rectangle(10, 2); 
		System.out.println("Area : "+r.calcArea());
		System.out.println("Peri : "+r.calcPeri());
		
		Shape c = new Circle(4.1); 
		System.out.println("Area : "+c.calcArea());
		System.out.println("Peri : "+c.calcPeri());
		
		Shape s = new Square(3.1); 
		System.out.println("Area : "+s.calcArea());
		System.out.println("Peri : "+s.calcPeri());
	}
}


