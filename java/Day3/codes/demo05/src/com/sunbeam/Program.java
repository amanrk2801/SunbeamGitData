package com.sunbeam;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		//int[][] arr = new int[3][3]; // heap section -- default 0
		//int[] arr[] = new int[3][3];  
		//int arr[][] = new int[3][3]; 
	
		double[][] arr = new double[][] {{1.1,2.1,3.1},{4.1,5.1,6.1}}; // 2 * 3   
		
		/*
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/ 
	
		//Ragged array -- Array of arrays 
		int[][] rarr = new int[4][];
		rarr[0] = new int[1];
		rarr[1] = new int[2];
		rarr[2] = new int[3];
		rarr[3] = new int[4];
		
		for(int i = 0 ; i < rarr.length ; i++) {
			for(int j = 0 ; j < rarr[i].length ; j++) {
				System.out.print(rarr[i][j] + " ");
			}
			System.out.println();
		}
		int count = 0; 
		for(int i = 0 ; i < rarr.length ; i++) {
			for(int j = 0 ; j < rarr[i].length ; j++) {
				rarr[i][j] = ++count; 
			}
			System.out.println();
		}
		for(int i = 0 ; i < rarr.length ; i++) {
			for(int j = 0 ; j < rarr[i].length ; j++) {
				System.out.print(rarr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}



