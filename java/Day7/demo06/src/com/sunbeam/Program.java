package com.sunbeam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Bounded generic types
//T can be any type so that T is Number or its sub-class.
class Box<T extends Number>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	} 
	
}
public class Program {

	public static void main(String[] args) {
		Box<Integer> b1 = new Box<>(); 
		b1.setObj(new Integer(10));
		System.out.println("r1 : "+b1.getObj());
		
		Box<Number> b2 = new Box<Number>(); 
		b2.setObj(new Long(12));
		System.out.println("r2 : "+b2.getObj());
		
		Box<Double> b3 = new Box<Double>();
		b3.setObj(new Double(11.33));
		System.out.println("r3 : "+b3.getObj());
		
		//Box<Object> b4 = new Box<Object>(); // Object is not a Number 
		//Box<String> b5 = new Box<String>(); //String is not a Number 
		//Box<Boolean> b6 = new Box<Boolean>(); // Boolean is not a Number 
	}

}


