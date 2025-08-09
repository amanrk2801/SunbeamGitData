package com.sunbeam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Java generics -- type-safety problem -- till Java 1.4
class Box{
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	} 
	
}
public class Program {

	public static void main(String[] args) {
		Box b1 = new Box(); 
		b1.setObj(new Integer(100));
		Integer r1 = (Integer) b1.getObj(); 
		System.out.println("r1 : "+r1);
		
		Box b2 = new Box(); 
		b2.setObj(new Double(11.33));
		Double r2 = (Double) b2.getObj(); 
		System.out.println("r2 : "+r2);
		
		Box b3 = new Box(); 
		b3.setObj(new Date());
		Date r3 = (Date) b3.getObj();
		System.out.println("r3 : "+r3);

		Box b4 = new Box(); 
		b4.setObj("Hello");
		String r4 = (String) b4.getObj();
		System.out.println("r4 : "+r4);
		
		Box b5 = new Box(); 
		b5.setObj("123");
		//Integer r5 = (Integer) b5.getObj();
		//System.out.println("r5 : "+r5);
	
		List list = new ArrayList(); 
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add("50"); 
		
		for(Object e : list) {
			Integer ele = (Integer) e;
			System.out.println(ele);
		}
	}

}


