package com.sunbeam;

import java.util.Scanner;

public class Program {
	public static int divide(int num, int den) {
		int res = num / den;
		return res;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the numerator : ");
			int num = sc.nextInt();
			System.out.print("Enter the Denominator : ");
			int den = sc.nextInt();
			int res = divide(num, den);
			System.out.println("res : " + res);
		} catch (Throwable e) {
			//e.printStackTrace();
			System.out.println("Message : "+e.getMessage());
		}

	}
}
