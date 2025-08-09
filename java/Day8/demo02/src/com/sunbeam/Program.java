package com.sunbeam;


public class Program {
	public static <T> void swap(T x , T y) {
		T temp = x;
		x = y; 
		y = temp; 
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);
	}
	public static void main(String[] args) {
		String s1 = "A"; 
		String s2 = "B"; 
		//swap(s1,s2); // T : String 
		
		Integer i = 10; 
		Double d = 11.33; 
		//swap(i,d); // T : Number 
		//Program.<Double>swap(i, d); // Integer -> Double 
	}

}
