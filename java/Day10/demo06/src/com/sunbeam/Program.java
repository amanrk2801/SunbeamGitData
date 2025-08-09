package com.sunbeam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;




public class Program {
	//private static Set<Employee> set = new HashSet<Employee>( );
	//private static Set<Employee> set = new LinkedHashSet<Employee>();
	private static Set<Employee> set = new TreeSet<Employee>();
	private static Scanner sc = new Scanner(System.in); 
	
	public static Employee[] getEmployees( ) {
		Employee[] arr = new Employee[5]; 
		arr[0] = new Employee(3, "Sagar", 3000.00); 
		arr[1] = new Employee(2, "Aditya", 2000.00); 
		arr[2] = new Employee(1, "Prashant", 1000.00); 
		arr[3] = new Employee(4, "Kunal", 4000.00);
		arr[4] = new Employee(4, "Kunal", 4000.00);
		return arr; 
	}
	public static void addEmployees(Employee[] emp) {
		 for (Employee e : emp) {
			  set.add(e); 
		}
		System.out.println();
	}
	public static void acceptRecord(int[] empid) {
		 System.out.print("Enter the empid : "); 
		 empid[0] = sc.nextInt(); 
	}
	public static Employee findEmployee(int empid) {
		
		for (Employee emp : set) {
			if(emp.getId() == empid)
				return emp; 
		}
		return null; 
		 
	}
	public static boolean removeEmployee(int empid) {
		Employee key = new Employee( ); 
		key.setId(empid);
		if(set.contains(key)) {
			set.remove(key); 
			return true; 
		}
		return false; 
	}
	public static void printRecord(Employee emp) {
		if(emp!=null) {
			System.out.println(emp.toString());
		}
		else 
			System.out.println("Record not found");
	}
	public static void printEmployees( ) {
		for (Employee emp : set) {
			System.out.println(emp.toString());
		} 
		System.out.println();
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.AddEmployees ");
		System.out.println("2.FindEmployee ");
		System.out.println("3.RemoveEmployee ");
		System.out.println("4.PrintEmployee ");
		System.out.print("Enter the choice : ");
		return sc.nextInt(); 
	}
	public static void main(String[] args) {
		int[] empid = new int[1]; 
		int choice; 
		while((choice = menuList())!=0) {
			switch (choice) {
			case 1: 
				set.clear(); 
				Employee[] arr = Program.getEmployees(); 
				Program.addEmployees(arr);
				break;
			case 2: 
				acceptRecord(empid);
				Employee emp = Program.findEmployee(empid[0]); 
				Program.printRecord(emp);
				break; 
			case 3: 
				acceptRecord(empid);
				boolean removedStatus = Program.removeEmployee(empid[0]);
				System.out.println(removedStatus ? "Employee removed " : "Employee not found");
				break; 
			case 4: 
				Program.printEmployees();
				break; 
			default:
				System.out.println("Invalid Choice");
			}
		}

	}

}
