package com.sunbeam;

class Math {
	public static int pow(int base , int index ) {
		int result = 1; 
		for(int i = 1 ; i <= index ; i++) {
			result = result * base; 
		}
		return result; 
	}
}

public class Program {
	public static void main(String[] args) {
		int res = Math.pow(2, 3); 
		System.out.println("res : "+res);
	}
}
