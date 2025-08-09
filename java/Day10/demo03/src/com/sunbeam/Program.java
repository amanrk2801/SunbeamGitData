package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Program {
	/* 
	public static void main(String[] args) {
		//(Elements are retrieved as per priority
		//-- decided by Comparable (Natural Ordering)
		Queue<String> q = new PriorityQueue<String>( );
		q.offer("S");
		q.offer("U");
		q.offer("N");
		q.offer("B");
		q.offer("E");
		q.offer("A");
		q.offer("M");
		
		while(!q.isEmpty()) {
			String ele = q.poll(); 
			System.out.println(ele);
		}
	}*/ 
	public static void main(String[] args) {
		class StringDescComparator implements Comparator<String> {

			@Override
			public int compare(String x, String y) {
				return y.compareTo(x);
			}

		}
		Queue<String> q = new PriorityQueue<String>(new StringDescComparator());
		q.offer("S");
		q.offer("U");
		q.offer("N");
		q.offer("B");
		q.offer("E");
		q.offer("A");
		q.offer("M");
		
		while(!q.isEmpty()) {
			String ele = q.poll(); 
			System.out.println(ele);
	}
}
}
