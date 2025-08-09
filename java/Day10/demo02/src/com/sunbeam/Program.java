package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Deque;

public class Program {

	/* 
	public static void main(String[] args) {
		//Dequeue as a Stack 
		Deque<Integer> q = new ArrayDeque<Integer>( ); 
		q.offerFirst(10);
		q.offerFirst(20);
		q.offerFirst(30);
		q.offerFirst(40);
		
		while(!q.isEmpty()) {
			Integer ele = q.pollFirst(); 
			System.out.println(ele);
		}

	}*/ 
	public static void main(String[] args) {
		//Dequeue as a Queue  
		Deque<Integer> q = new ArrayDeque<Integer>( ); 
		q.offerLast(10); 
		q.offerLast(20);
		q.offerLast(30);
		q.offerLast(40); 
		
		while(!q.isEmpty()) {
			Integer ele = q.pollFirst(); 
			System.out.println(ele);
		}

	}

}
