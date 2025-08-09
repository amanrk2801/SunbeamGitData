package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Program {
	public static void main(String[] args) {
		//ArrayList<Integer> list = new ArrayList<Integer>( );
		//LinkedList<Integer> list = new LinkedList<Integer>();
		Vector<Integer> list = new Vector<Integer>( ); 
		Collections.addAll(list, 11,22,33,44,55); 
		
		System.out.println("for-each loop (Since Java 1.2) ( works for all Collections) ");
		for (Integer ele : list) {
			System.out.println(ele);
		}
		System.out.println("Using Iterator (Since Java 1.2) ( works for all Collections) ");
		Iterator<Integer> trav = list.iterator();  
		while(trav.hasNext()) {
			Integer ele = trav.next(); 
			System.out.println(ele);
		}
		System.out.println("For loop(works for all List) ");
		
		for(int i = 0 ; i < list.size() ; i++) {
			Integer ele = list.get(i); 
			System.out.println(ele);
		}
		System.out.println("Using Enumeration (Since Java 1.0)(Vector)");
		Enumeration<Integer> en = list.elements(); 
		while(en.hasMoreElements()) {
			Integer ele = en.nextElement(); 
			System.out.println(ele);
		}
		


		
	}
}
