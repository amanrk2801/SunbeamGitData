package com.sunbeam;

@FunctionalInterface
public interface Shape {
	/*public static final*/double PI = 3.14; 
	/*public abstract*/double calcArea( ); 
	//we can define static methods inside interface from java 8 
	public static double calcTotalArea(Shape[] arr) {
		double total = 0.0; 
		for(int i = 0 ; i < arr.length ; i++) {
			total = total + arr[i].calcArea(); 
		}
		return total; 
	}
	default double calcPeri( ) {
		return 0.0; 
	}
	 
	
}
/* 
class Shapes{
	public static double calcTotalArea(Shape[] arr) {
		double total = 0.0; 
		for(int i = 0 ; i < arr.length ; i++) {
			total = total + arr[i].calcArea(); 
		}
		return total; 
	}
}*/ 