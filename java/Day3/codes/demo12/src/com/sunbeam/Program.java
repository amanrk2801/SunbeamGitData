package com.sunbeam;
public class Program {
	//variable arity method -- java 5.0 
	public static void print(Object... arr) {
		for(int i = 0 ; i < arr.length ; i ++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		Program.print("Hello" , 11 , 11.33);
	}	

}
/* 
public class Program {
	//variable arity method -- java 5.0 
	public static double arraySum(double... arr) {
		double total = 0.0; 
		for(int i = 0 ; i < arr.length ; i++) {
			total = total + arr[i]; 
		}
		return total; 
	}
	public static void main(String[] args) {
		//double[] arr1 = {1.1, 2.1, 3.1}; // Named array 
		double r1 = Program.arraySum(1.1,2.1,3.3); 
		System.out.println("r1 : "+r1);
		
		//double[] arr2 = {2.1, 3.1, 4.1}; // Named array 
		double r2 = Program.arraySum(2.1,3.1,4.1); 
		System.out.println("r1 : "+r2);
		
		double r3 = Program.arraySum(new double[] {1.1,2.2,3.3,4.4}); // passing Anonymous array 
		System.out.println("r3 : "+r3);
	}	

}*/ 
/* 
public class Program {
	public static double arraySum(double[] arr) {
		double total = 0.0; 
		for(int i = 0 ; i < arr.length ; i++) {
			total = total + arr[i]; 
		}
		return total; 
	}
	public static void main(String[] args) {
		double[] arr1 = {1.1, 2.1, 3.1}; // Named array 
		double r1 = Program.arraySum(arr1); 
		System.out.println("r1 : "+r1);
		
		double[] arr2 = {2.1, 3.1, 4.1}; // Named array 
		double r2 = Program.arraySum(arr2); 
		System.out.println("r1 : "+r2);
		
		double r3 = Program.arraySum(new double[] {1.1,2.2,3.3,4.4}); // passing Anonymous array 
		System.out.println("r3 : "+r3);
	}	

}*/ 
/* 
public class Program {
	private static void add(int a, int b) {
		int res = a + b; 
		System.out.println("res : "+res);
	}
	private static void add(int a, int b , int c) {
		int res = a + b; 
		System.out.println("res : "+res);
	}
	private static void add(int a, int b , int c , int d ) {
		int res = a + b; 
		System.out.println("res : "+res);
	}
	public static void main(String[] args) {
		Program.add(10, 20);
		Program.add(10, 20 , 30);
		Program.add(10, 20 , 30 , 40);
	}

	

	

}*/ 



