package com.sunbeam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Java generics -- type-safety problem -- since java 5.0 
class Box<T>{
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
		Box<Integer> b1 = new Box<Integer>(); // T : Integer 
		b1.setObj(new Integer(10));
		Integer r1 = b1.getObj(); 
		System.out.println("r1 : "+r1);
		
		Box<Double> b2 = new Box<Double>(); // T : Double
		b2.setObj(new Double(11.33));
		Double r2 = b2.getObj(); 
		System.out.println("r2 : "+r2);
		
		Box<Date> b3 = new Box<Date>();  // T : Date 
		b3.setObj(new Date());
		Date r3 = b3.getObj(); 
		System.out.println("r3 : "+r3);
		
		Box<String> b4 = new Box<>(); // T : String
		b4.setObj("Hello");
		String r4 = b4.getObj(); 
		System.out.println("r4 : "+r4);
		
		Box<Integer> b5 = new Box<Integer>(); 
		//b5.setObj("123");// type-checking at compile time 
		
		Box b6 = new Box();  // raw type 
		b6.setObj(null);
		Object r5 = b6.getObj();
		System.out.println("r5 : "+r5);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); 
		list.add(20); 
		list.add(30); 
		//list.add("ABC"); // type-safety (Type checking at compile time)  
		
		for(Integer ele : list) {
			System.out.println(ele);
		}
	}

}


