package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.domain.Employee;
import com.util.CompareByEmpid;
import com.util.CompareByName;
import com.util.CompareBySalary;

public class Program {
	public static Employee[] getInstances() {
		Employee[] arr = new Employee[4];
		arr[0] = new Employee(3, "Rohan", 3000.00);
		arr[1] = new Employee(4, "Ketan", 2000.00);
		arr[2] = new Employee(1, "Aditya", 4000.00);
		arr[3] = new Employee(2, "Sagar", 1000.00);
		return arr;
	}

	public static void print(Employee[] arr, Comparator<Employee> comparator) {
		Arrays.sort(arr, comparator);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int menuList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0.Exit");
		System.out.println("1.CompareByID : ");
		System.out.println("2.CompareByName : ");
		System.out.println("3.CompareBySalary : ");
		System.out.println("Enter the choice : ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		Employee[] arr = Program.getInstances();
		int choice;
		while ((choice = menuList()) != 0) {
			Comparator<Employee> comparator = null;
			switch (choice) {
			case 1:
				comparator = new CompareByEmpid( ); // upcasting 
				break;
			case 2: 
				comparator = new CompareByName( ); // upcasting 
				break;
			case 3: 
				comparator = new CompareBySalary( ); // upcasting
				break; 
			default:
				System.out.println("Invalid Choice : ");
				break;
			}
			Program.print(arr, comparator);
			//if arr is null natural ordering will be used 
		}
	}
}
