package com.sunbeam;

import java.util.Scanner;

public class Program {
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the number : ");
		int num = sc.nextInt(); 
		System.out.println("Square : "+num * num);
	}
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the number : ");
		int num = sc.nextInt(); 
		System.out.println("Square : "+num * num);
		System.out.println("Resource closed");
		sc.close();
	}
	public static void main3(String[] args) {
		Scanner sc = new Scanner(System.in); 
		try {
			System.out.println("Enter the number : ");
			int num = sc.nextInt(); 
			System.out.println("Square : "+num * num);
		}
		finally {
			System.out.println("Resource closed");
			sc.close();
		}
	}
	public static void main4(String[] args) {
		Scanner sc = new Scanner(System.in); 
		try {
			System.out.println("Enter the number : ");
			int num = sc.nextInt(); 
			System.out.println("Square : "+num * num);
			System.exit(0);
		}
		finally {
			System.out.println("Resource closed");
			sc.close();
		}
	}
	public static void main5(String[] args) {
		try(Scanner sc = new Scanner(System.in)){ // try--with--resource 
			System.out.println("Enter the number : ");
			int num = sc.nextInt(); 
			System.out.println("Square : "+num * num);
		}//sc.close() called automatically 
	}
	public static void main(String[] args) {
		class MyResource implements AutoCloseable{
			public MyResource() {
				System.out.println("MyResource intiated");
			}
			@Override
			public void close(){
				System.out.println("Resource closed");
				
			}
			
		}
		try(MyResource myResource = new MyResource()){
			System.out.println("MyResource");	
		}//myResource.close(); 
	}
}






