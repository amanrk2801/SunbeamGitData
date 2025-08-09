package com.sunbeam;

import static com.sunbeam.Chair.getPrice; 
import static com.sunbeam.Chair.setPrice;
import static java.lang.Math.*;

import java.util.Scanner; 
//import all static members (fields + methods) from the Math class
public class Program {
	public static double calcArea(double rad) {
		return PI * rad * rad; 
	}
	public static void main(String[] args) {
		Chair c1 = new Chair(10, 20); 
		
		//System.out.println("Price : "+Chair.getPrice());
		//System.out.println("Price : "+getPrice());
		
		//Chair.setPrice(500);
		//setPrice(500); 
		//System.out.println("Price : "+getPrice());
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the rad : ");
		double rad = sc.nextDouble(); 
		//double area = Program.calcArea(rad);
		double area = calcArea(rad);
		System.out.println("Area : "+area);
	}

}
