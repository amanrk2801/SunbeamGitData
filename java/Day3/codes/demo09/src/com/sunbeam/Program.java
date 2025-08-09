package com.sunbeam;

import java.util.Arrays;
import java.util.Scanner;

/*
 java.util.Arrays class contains lot of helper methods to perform operations on arrays.
All these methods are static methods -- called directly on classname.
Example:
	toString()
	sort()
	binarySearch() 
  
 */
public class Program {
	public static void main(String[] args) {
		int[] arr = {22,11,5,8,99}; 
		
		System.out.println("Ele : "+Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		System.out.println("Ele : "+Arrays.toString(arr));
	}

}



