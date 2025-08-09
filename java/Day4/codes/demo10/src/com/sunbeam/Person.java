package com.sunbeam;
//person class 
public class Person {
	private String name; 
	private int age; 
	public Person() {
		System.out.println("public Person()");
	}
	public Person(String name, int age) {
		System.out.println("public Person(String name, int age) ");
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void display( ) {
		System.out.println("Name : "+this.name);
		System.out.println("Age : "+this.age);
		
	}
	
}
