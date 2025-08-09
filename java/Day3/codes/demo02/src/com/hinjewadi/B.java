package com.hinjewadi;

public class B extends A {
	public void display( ) {
		//System.out.println(a); // private 
		System.out.println(b); // OK 
		System.out.println(c); // OK 
		System.out.println(d); // OK 
	}
}
