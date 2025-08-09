package com.sunbeam;

public class Student extends Person {
	private int roll; 
	private String course; 
	private int marks; 
	public Student() {
		System.out.println("public Student() ");
	}
	public Student(String name , int age , int roll, String course, int marks) {
		super(name,age); 
		System.out.println("public Student(int roll, String course, int marks)");
		this.roll = roll;
		this.course = course;
		this.marks = marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public void display( ) {
		//System.out.printf("Name : %s\nAge : %d\n",super.getName(),this.getAge());
		super.display();
		System.out.println("Roll : " + this.roll);
		System.out.println("Name : "+this.course);
		System.out.println("Marks : "+this.marks);
	}
	
}
