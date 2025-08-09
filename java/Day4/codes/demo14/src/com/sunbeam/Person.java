package com.sunbeam;

public class Person {
	private String name;
	private int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showRecord() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
	}

}
