package com.sunbeam;

public class Program {
	//generic method using java.lang.Object -- till Java 1.4  
	public static void printObjectArray(Object[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			//String ele = (String) arr[i]; // If arr is not a String it will cause class-cast exception   
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
			Object[] arr1 = {"11", "22" , "33" , 44 , "55"};   
			//printObjectArray(arr1);
			
			String[] arr2 = {"Amit" , "Rohan" , "Aditya", "Sagar", "Prashant"};
			printObjectArray(arr2);
		*/ 
		
		/*
		Integer[] arr3 = {11,22,33,44,55}; 
		//printTypedArray(arr3); // T : Integer
		Program.<Number>printTypedArray(arr3);
		
		String[] arr2 = {"Amit" , "Rohan" , "Aditya", "Sagar", "Prashant"};
		//printTypedArray(arr2);  //  T : String 
		//Program.<Number>printTypedArray(arr2); // String is not a Number 
		
		Double[] arr4 = {11.33, 12.33, 33.33, 44.44 , 55.55}; 
		//printTypedArray(arr4); // T : Double 
		Program.<Number>printTypedArray(arr4);
		*/ 
		
		Integer[] arr3 = {11,22,33,44,55}; 
		Program.<Number>printNumberArray(arr3);
		
		String[] arr2 = {"Amit" , "Rohan" , "Aditya", "Sagar", "Prashant"};
		//printNumberArray(arr2);
		
		Double[] arr4 = {11.33, 12.33, 33.33, 44.44 , 55.55}; 
		//printNumberArray(arr4);
		Program.<Number>printNumberArray(arr4);
	}

}
