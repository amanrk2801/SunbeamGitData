package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Program {
	
	/* 
	public static void main(String[] args) {
		//fail fast iterators 
		List<Integer> list = new ArrayList<Integer>(); 
		Collections.addAll(list,11,22,33,44,55); 
		
		Iterator<Integer> trav = list.iterator(); 
		while(trav.hasNext()) {
			Integer ele = trav.next(); 
			System.out.println(ele);
			if(ele == 33)
			  list.add(3, 100);
		}

	}*/ 
	public static void main(String[] args) {
		//fail safe iterator 
		List<Integer> list = new CopyOnWriteArrayList<Integer>(); 
		Collections.addAll(list,11,22,33,44,55);
		Iterator<Integer> trav = list.iterator(); 
		
		while(trav.hasNext()) {
			Integer ele = trav.next(); 
			System.out.println(ele);
			if(ele == 33)
				list.add(3,100); 
		}
		System.out.println("Updated list");
		trav = list.iterator(); 
		while(trav.hasNext()) {
			Integer ele = trav.next(); 
			System.out.println(ele);
			if(ele == 33)
				list.add(3,100); 
		}
	}

}
