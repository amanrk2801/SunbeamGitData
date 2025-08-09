package com.sunbeam;

class MyClass{
	public MyClass() {
		System.out.println("Resource allocated");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Resource closed");
	}
}
public class Program {

	public static void main(String[] args) {
		MyClass obj = new MyClass(); 
		obj = null; //elgible for GC 
		System.gc(); 
	}
}
