package com.sunbeam;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		
		int[] arr2 = new int[] {10,20,30,40,50};
		
		int[] arr3 = {10,20,30,40,50};
		
		/* 
		for(int i = 0 ; i < arr3.length ; i++)
			System.out.println(arr3[i]);
		*/ 
		double[] arr = new double[3]; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the elements : ");
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextDouble(); 
		}
		double sum = Program.arraySum(arr); 
		System.out.println("Sum : "+sum);
	}
	public static double arraySum(double[] a) {
		double total = 0.0; 
		for(int i = 0 ; i < a.length ; i++) {
			total = total + a[i]; 
		}
		return total;  
	}

}



