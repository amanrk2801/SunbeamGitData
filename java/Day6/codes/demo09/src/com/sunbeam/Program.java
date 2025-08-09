package com.sunbeam;

import java.util.Scanner;

public class Program {
	/* 
	// handling the possible errors -- programmatically
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the numerator : ");
		int num = sc.nextInt(); 
		System.out.print("Enter the Denominator : ");
		int den = sc.nextInt();
		if(den!=0) {
			int res = num / den; 
			System.out.println("res : "+res);
		}
		else 
			System.out.println("Divide by zero");
	}*/ 
	public static int divide(int num , int den) {
		if(den == 0) {
			System.out.println("Divide by zero");
			//System.exit(0);
		}
		int res = num / den; 
		return res; 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the numerator : ");
		int num = sc.nextInt(); 
		System.out.print("Enter the Denominator : ");
		int den = sc.nextInt();
		int res = divide(num,den); 
		System.out.println("res : "+res);
	}
	//CODE 
}






