package com.sunbeam;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>( ); 
		Collections.addAll(set,"A","B","C","D","E","F","G","H","I","J","K");
		
		System.out.println("Set : "+set); //[A, B, C, D, E, F, G, H, I, J, K]
		System.out.println("First : "+set.first()); //A
		System.out.println("Last : "+set.last());  //K 
		
		System.out.println("HeadSet : "+set.headSet("E"));//[A, B, C, D]
		System.out.println("TailSet : "+set.tailSet("G"));//[G, H, I, J, K]
		System.out.println("SubSet : "+set.subSet("B", "F"));//[B, C, D, E]
		
		System.out.println("Higher : "+set.higher("E")); //F 
		System.out.println("Lower : "+set.lower("D")); //C
		
		Iterator<String> trav = set.descendingIterator(); 
		while(trav.hasNext()) {
			String ele = trav.next(); 
			System.out.print(ele + " ");
		}
		System.out.println();
		
		NavigableSet<String> descSet = set.descendingSet();//K J I H G F E D C B A 
		System.out.println(descSet); //[K, J, I, H, G, F, E, D, C, B, A]
	}

}
