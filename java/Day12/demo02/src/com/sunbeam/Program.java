package com.sunbeam;

import java.io.Console;
import java.util.Comparator;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

//lambda expr = short-hand implementation of SAM (functional interface)
//method ref = short-hand of lambda expr
public class Program {

	public static void main(String[] args) {
		//BinaryOperator<Integer> op1 = (x,y) -> Integer.sum(x, y);
		
		
		//static method of a class --> 
		//ClassName.method(arg1, arg2); i.e. static method called on ClassName
		BinaryOperator<Integer> op1 =Integer::sum; // :: method reference operator  
		int a = 10 , b = 20; 
		//System.out.println("res : "+ op1.apply(a, b));
	
		//non-static method reference
		//Comparator<String> cmp = (x,y) -> x.compareTo(y); 
		// non-static method of a class --> 
		//arg1.method(arg2); i.e. non-static method called on arg1
		Comparator<String> cmp = String::compareTo; 
		String s1 = "Sunbeam" , s2 = "SunBeam"; 
		//System.out.println("Res : "+cmp.compare(s1, s2));
		
		//Consumer<Double> c = d -> System.out.println(d);
		// non-static method to call on obj
		//--> obj.method(arg); i.e. non-static method called on given object
		Consumer<Double> c = System.out::println;
		double d = 11.33; 
		c.accept(d);
		
		//Supplier<Date> dt = () -> new Date();
		
		// constructor reference
		// param-less constructor is called after creating object of given class.
		Supplier<Date> dt = Date::new; 
		System.out.println("Date : "+dt.get());
		
		
		
		
	}
		
	

}
