package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

//Application version 2.0
@Deprecated
class MyClass{
	@Deprecated
	public void oldMethod( ) {
		System.out.println("MyClass.oldMethod()");
	}
	public void newMethd( ) {
		System.out.println("MyClass.newMethod()");
	}
}
public class Program {
	
	/* 
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList(); 
		String str = "Hello"; 
	}*/ 
	public static void main(String[] args) {
		MyClass obj1 = new MyClass(); 
		obj1.oldMethod();
		
		MyClass obj2 = new MyClass(); 
		obj2.newMethd(); 
	}

}
