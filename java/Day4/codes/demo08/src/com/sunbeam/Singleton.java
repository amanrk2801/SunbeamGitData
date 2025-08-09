package com.sunbeam;

public class Singleton {
	// single copy 
	private static Singleton obj; 
	//static block will executed only once 
	static {
		obj = new Singleton(); 
	}
	//Object of this class will not be created outside the class 
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	public static Singleton getInstance() {
		return obj;
	}
}
