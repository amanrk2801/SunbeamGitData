package com.sunbeam;

public class Date implements Cloneable{
	private int day; 
	private int month; 
	private int year; 
	public Date() {
		// TODO Auto-generated constructor stub
	}
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//this = dt1; 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object temp = super.clone(); // shallow copy of instances  
		return temp; 
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
	
}
