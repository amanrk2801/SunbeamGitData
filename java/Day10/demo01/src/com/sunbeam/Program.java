package com.sunbeam;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
	
	/* 
	public static void main(String[] args) {
		Queue<String> q = new ArrayDeque<String>( ); // LinkedList();
		//Queue<String> q = new LinkedList<String>(); 
		q.offer("One"); 
		q.offer("Two"); 
		q.offer("Three"); 
		q.offer("Four"); 
		q.offer("Five"); 
		
		System.out.println("First element : "+ q.peek());
		while(!q.isEmpty()) {
			String ele = q.poll(); 
			System.out.println(ele);
		}
		System.out.println("Removing ele from empty queue : "+q.poll());

	}*/ 
	public static void main(String[] args) {
		//Queue<String> q = new ArrayDeque<String>( );
		Queue<String> q = new LinkedList<String>(); 
		q.add("One");
		q.add("Two");
		q.add("Three");
		q.add("Four");
		q.add("Five");
		
		System.out.println("First ele  : " + q.element());
		
		while(!q.isEmpty()) {
			String ele = q.remove(); 
			System.out.println(ele);
		}
		
		System.out.println("Deleting ele from empty queue : "+q.remove());
		
		
	}

}
