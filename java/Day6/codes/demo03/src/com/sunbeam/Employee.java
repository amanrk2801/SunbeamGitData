package com.sunbeam;

public class Employee {
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
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}
	//this = e1; 
	//obj = e2; 
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false; 
		if(this == obj)
			return true;
		if(!(obj instanceof Employee))
			return false; 
		Employee other = (Employee) obj; 
		if(this.empid == other.empid)  
		   return true; 
		return false; 
	}
	
}
