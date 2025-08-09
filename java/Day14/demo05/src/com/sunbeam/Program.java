package com.sunbeam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

enum Operations{
	EXIT,ADD,FIND,REMOVE,PRINT,WRITE,READ
}
class Employee implements Serializable{
	private int empid; 
	private String name; 
	private double salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empid == other.empid;
	}
	@Override
	public String toString() {
		return String.format("%-15d %-10s %10.2f",this.empid,this.name,this.salary); 
	}
	
}
public class Program {
	private static Scanner sc = new Scanner(System.in); 
	private static List<Employee> empList = new ArrayList<Employee>(); 
	
	public static Employee[] getEmployees(){
		Employee[] arr = new Employee[4]; 
		arr[0] = new Employee(3, "Aditya", 3000.00); 
		arr[1] = new Employee(2, "Rahul", 4000.00); 
		arr[2] = new Employee(1, "Pratik", 2000.00); 
		arr[3] = new Employee(4, "Kunam", 1000.00);
		return arr;  
	}
	public static void addEmployees(Employee[] employees) {
		for (Employee e : employees) {
			empList.add(e); 
		} 
	}
	public static void acceptRecord(int[] empid) {
		System.out.println("Enter the empid : ");
		empid[0] = sc.nextInt(); 
	}
	public static Employee findEmployee(int empid) {
		Employee key = new Employee(); 
		key.setEmpid(empid);
		int index = empList.indexOf(key);  
		if(index!=-1) {
			return empList.get(index); 
		}
		return null; 
	}
	public static boolean removeEmployee(int empid) {
		Employee key = new Employee(); 
		key.setEmpid(empid);
		if(empList.contains(key)) {
			empList.remove(key); 
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
		System.out.println();
	}
	public static void printEmployees() {
		empList.sort((x,y) -> Integer.compare(x.getEmpid(), y.getEmpid()));
		empList.forEach(System.out::println);
	}
	public static void writeRecord(String path) throws Exception{
		try(FileOutputStream fout = new FileOutputStream(path)){
			try(BufferedOutputStream bout = new BufferedOutputStream(fout)){
				try(ObjectOutputStream oout = new ObjectOutputStream(bout)){
					oout.writeObject(empList);
				}
			}
		}
	}
	public static void readRecord(String path) throws Exception{
		try(FileInputStream fin = new FileInputStream(path)){
			try(BufferedInputStream bin = new BufferedInputStream(fin)){
				try(ObjectInputStream oin = new ObjectInputStream(bin)){
					empList = (List<Employee>) oin.readObject(); 
				}
			}
		}
	}
	public static Operations menu_list() {
		Operations[] oprVal = Operations.values(); 
		for (Operations op : oprVal) {
			System.out.println(op.ordinal() + "." + op.name());
		}
		System.out.println("Enter the choice : ");
		return oprVal[sc.nextInt()]; 
	}
	
	public static void main(String[] args) {
		int[] empid = new int[1]; 
		Operations choice; 
		while((choice = menu_list())!=Operations.EXIT) {
			try {
				switch (choice) {
				case ADD:
					Employee[] emp = Program.getEmployees(); 
					Program.addEmployees(emp);
					break;
				case FIND:
					Program.acceptRecord(empid);
					Employee e = Program.findEmployee(empid[0]); 
					Program.printRecord(e);
					break; 
				case REMOVE: 
					Program.acceptRecord(empid);
					boolean removedStatus = Program.removeEmployee(empid[0]); 
					System.out.println(removedStatus ? "Employee removed " : "Employee not found");
					break; 
				case PRINT: 
					Program.printEmployees();
					break; 
				case WRITE: 
					Program.writeRecord("Employees.db");
					break; 
				case READ: 
					Program.readRecord("Employees.db");
					Program.printEmployees();
					break; 
				default:
					System.out.println("Invalid choice");
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
