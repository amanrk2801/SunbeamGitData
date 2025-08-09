package com.sunbeam;

import java.util.InputMismatchException;
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
	/* 
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
	}*/ 
	
	/* 
	//detect the problem and throw the problem 
	public static int divide(int num , int den) {
		if(den == 0) {
			throw new RuntimeException("Divide by zero"); 
		}
		int res = num / den; 
		return res; 
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		try {
			System.out.print("Enter the numerator : ");
			int num = sc.nextInt(); 
			System.out.print("Enter the Denominator : ");
			int den = sc.nextInt();
			int res = divide(num,den); 
			System.out.println("res : "+res);
		}
		catch (RuntimeException e) {
			System.out.println("Divide by zero");
		}
	}*/ 
	/* 
	//detect the problem and throw the problem 
		public static int divide(int num , int den) {
			int res = num / den;//  divide operator may throw ArithmeticException 
			return res; 
		}
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in); 
			try {
				System.out.print("Enter the numerator : ");
				int num = sc.nextInt(); 
				System.out.print("Enter the Denominator : ");
				int den = sc.nextInt();
				int res = divide(num,den); 
				System.out.println("res : "+res);
			}
			catch (ArithmeticException e) {
				System.out.println("Divide by zero");
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
		}
	*/ 
	/* 
	//detect the problem and throw the problem 
	public static int divide(int num , int den) {
		int res = num / den;//  divide operator may throw ArithmeticException 
		return res; 
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		try {
			System.out.print("Enter the numerator : ");
			int num = sc.nextInt(); 
			System.out.print("Enter the Denominator : ");
			int den = sc.nextInt();
			int res = divide(num,den); 
			System.out.println("res : "+res);
		}
		catch (ArithmeticException | InputMismatchException e) {
			System.out.println("Invalid input");
		}
		
	}*/ 
	/*
	//detect the problem and throw the problem 
		public static int divide(int num , int den) {
			int res = num / den;//  divide operator may throw ArithmeticException 
			return res; 
		}
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in); 
			try {
				System.out.print("Enter the numerator : ");
				int num = sc.nextInt(); 
				System.out.print("Enter the Denominator : ");
				int den = sc.nextInt();
				int res = divide(num,den); 
				System.out.println("res : "+res);
			}
			catch (ArithmeticException | InputMismatchException e) {
				System.out.println("Invalid input");
			}
			finally {
				sc.close(); // to close the resource 
			}
			
		}
	*/ 
	//detect the problem and throw the problem as checked exception  
			public static int divide(int num , int den) throws Exception  
			{
				int res = num / den; 
				return res; 
			}
			public static void main(String[] args) {
				
				Scanner sc = new Scanner(System.in); 
				try {
					System.out.print("Enter the numerator : ");
					int num = sc.nextInt(); 
					System.out.print("Enter the Denominator : ");
					int den = sc.nextInt();
					int res = divide(num,den); 
					System.out.println("res : "+res);
				}
				catch (Exception e) {
					System.out.println("Divide by zero");
				}
				
				
			}
}






