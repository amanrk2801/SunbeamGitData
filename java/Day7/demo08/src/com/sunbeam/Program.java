package com.sunbeam;

public class Program {
	// generic method using java.lang.Object -- till Java 1.4) 
	public static void printObjectArray(Object[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			//Integer ele = (Integer) arr[i]; // if ele is not a Integer it will throw ClassCastExceptio
			System.out.println(arr[i]);
		}
	}
	
	//generic method using generic type param -- since Java 5.0   
	public static <T> void printTypedArray(T[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			T ele = arr[i]; 
			System.out.println(ele);
		}
	}
	//generic method using bounded generic type param -- since Java 5.0
	public static <T extends Number> void printNumberArray(T[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			T ele = arr[i]; 
			System.out.println(ele);
		}
	}
	
	public static void main(String[] args) {
		/* 
			Object[] arr1 = { 11 , 22 , "33" , 44}; 
			//printObjectArray(arr);
			
			String[] arr2 = {"Rohan", "Ketan", "Aditya", "Sumit" , "Omkar"}; 
			printObjectArray(arr2);
		*/
		/* 
			Integer[] arr1 = { 11 , 22 , 33 , 44}; 
			printTypedArray(arr1); // T : Integer 
			
			String[] arr2 = {"Rohan", "Ketan", "Aditya", "Sumit" , "Omkar"};
			printTypedArray(arr2); // T : String
			
			Double[] arr3 = { 11.22 , 22.22 , 33.33 , 44.44};
			Program.<Double>printTypedArray(arr3);
		*/ 
		 
		Integer[] arr1 = { 11 , 22 , 33 , 44}; 
		printNumberArray(arr1); // T : Integer 
		
		String[] arr2 = {"Rohan", "Ketan", "Aditya", "Sumit" , "Omkar"};
		//printNumberArray(arr2); // NOT OK 
		
		Double[] arr3 = { 11.22 , 22.22 , 33.33 , 44.44};
		Program.<Number>printTypedArray(arr3);
	 
	}
}
