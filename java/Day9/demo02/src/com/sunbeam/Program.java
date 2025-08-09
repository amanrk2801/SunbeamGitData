package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Program {

	public static void main(String[] args) {
		List<String>list = new ArrayList<>();
		list.add("India"); 
		list.add("USA"); 
		list.add("China"); 
		list.add("Russia"); 
		list.add("India"); 
		list.add("Nepal");
		list.add("England"); 
		System.out.println("Size : "+list.size());
		
		System.out.println("toString() : "+list.toString());
		//random access ( get , set , add  , remove )  
		list.add(3, "Iran");
		System.out.println("toString() : "+list.toString());
		
		
		int index = 5; 
		String e5 = list.get(index); 
		System.out.println("Ele : "+e5);
		e5 = e5.toUpperCase(); 
		list.set(index, e5); 
		System.out.println("toString() : "+list.toString());
		
		list.remove(index);  //delete the element at index 
		System.out.println("toString() : "+list.toString());
		System.out.println();
		//contains() 
		String find = "USA"; 
		boolean found = list.contains(find); 
		if(found)
			System.out.println("Ele : " + find + " found ");
		else 
			System.out.println("Ele" + find + " not found");
		//indexOf() , lastIndexOf() ---(find the element and access it )
		System.out.println();
		int idx = list.indexOf(find); 
		if(idx!=-1) {
			System.out.println("Ele " + find + " found at index " + idx);
		}
		else
			System.out.println("Element not found");
		
		System.out.println();
		idx = list.lastIndexOf(find);	
		if(idx!=-1) {
			System.out.println("Ele " + find + " found at index " + idx);
		}
		else
			System.out.println("Element not found");
		System.out.println();
		System.out.print("FWD : ");
		ListIterator<String> trav = list.listIterator();  
		while(trav.hasNext()) {
			String ele = trav.next(); 
			System.out.print(ele + " ");
		}
		System.out.println();
		System.out.print("REV : ");
		trav = list.listIterator(list.size()); 
		while(trav.hasPrevious()) {
			String ele = trav.previous(); 
			System.out.print(ele + " ");
		}
		list.clear(); 
		System.out.println();
		
		
		Collections.addAll(list,"Rohan","Ketan","Aditya","Kunal","Sagar"); 
		System.out.println();
		System.out.println("toString() : "+list.toString());
		
		Collections.sort(list);
		
		System.out.println("toString() : "+list.toString());
		
		Collections.shuffle(list);
		
		System.out.println("toString() : "+list.toString());
		System.out.println();
		class StringDescComparator implements Comparator<String>{

			@Override
			public int compare(String x, String y) {
				return -x.compareTo(y); 
			}
			
		}
		Collections.sort(list, new StringDescComparator()); 
		System.out.println("toString() : "+list.toString());
	}

}
