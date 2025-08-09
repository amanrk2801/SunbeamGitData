package com.sunbeam;


/* 
public class Program {
	private static void swap(int a, int b) {
		int temp = a; 
		a = b; 
		b = temp; 
		System.out.println(" a  = " + a + " b = " + b);
	}
	public static void main(String[] args) {
		int a = 1 , b = 2; 
		System.out.println(" a  = " + a + " b = " + b);
		swap(a,b); 
		System.out.println(" a  = " + a + " b = " + b);
	}

	

}*/ 

public class Program {
	private static void swap(int[] a) {
		int temp = a[0]; 
		a[0] = a[1]; 
		a[1] = temp; 
		System.out.println(" a[0]  = " + a[0] + " a[1] = " + a[1]);
	}
	public static void main(String[] args) {
		int[] a = {1,2};   
		System.out.println(" a[0]  = " + a[0] + " a[1] = " + a[1]);
		swap(a);  
		System.out.println(" a[0]  = " + a[0] + " a[1] = " + a[1]);
	}

	

}



