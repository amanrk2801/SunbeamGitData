package com.sunbeam;
public class Program {
	
	public static void main(String[] args) {
		int total = 0; 
		for(int i = 0 ; i < args.length ; i++) {
			int number = Integer.parseInt(args[i]); 
			total = total + number; 
		}
		System.out.println("total : "+total);
	}

	

}



