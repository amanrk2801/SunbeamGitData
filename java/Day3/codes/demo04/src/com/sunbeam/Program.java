package com.sunbeam;

import java.util.Scanner;

public class Program {
	public static void acceptRecord(int[] a) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the elements : ");
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = sc.nextInt(); 
		}
	}
	public static void printRecord(int[] a) {
		if(a!=null) {
			for(int i = 0 ; i < a.length ; i++) {
				System.out.println(a[i]);
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[3]; 
		Program.acceptRecord(arr);
		Program.printRecord(arr);
	}
	public static void main4(String[] args) {
		int[] arr = new int[3]; 
		System.out.println(arr[-1]);
	}
	public static void main3(String[] args) {
		int[] arr = new int[-3]; 
	}
	public static void main2(String[] args) {
		int[] arr = null; //reference 
		arr = new int[3]; // instance 
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
	public static void main1(String[] args) {
		int[] arr = null; // OK
		//int arr[] = null; // OK
		//int [arr] = null; // NOT OK
	}
	

}



