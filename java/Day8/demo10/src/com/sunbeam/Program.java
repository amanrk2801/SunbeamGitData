package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		//Collection<String> c = new ArrayList<String>( );
		Collection<String> c = new LinkedList<String>(); 
		c.add("India"); 
		c.add("USA");
		c.add("India");
		c.add("Japan");
		c.add("China");
		c.add("Nepal");
		c.add("Russia");
		
		System.out.println("Size : "+c.size());
		
		c.remove("India"); 
		System.out.println();
		System.out.println("Ele : " + c.toString());
		
		
		Iterator<String> trav = c.iterator(); 
		
		while(trav.hasNext()) {
			String ele = trav.next();  
			System.out.println(ele);
		}
		
		System.out.println("Ele : " + c.toString());
		
		c.clear(); 
		System.out.println("Size : "+c.size());
		
		
	}

}



