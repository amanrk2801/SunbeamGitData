package com.sunbeam;

public class PriorityQueueMain {

	public static void main(String[] args) {
		
		PriorityQueue q = new PriorityQueue(9);
		
		System.out.println("isEmpty : " + q.isEmpty());	// true
		System.out.println("isFull : " + q.isFull());	// false
		
		q.push(6);
		q.push(14);
		q.push(3);
		q.push(26);
		
		System.out.println("Peeked data : " + q.peek());	// 26
		
		q.pop();
		System.out.println("Peeked data : " + q.peek());	//14
		
		q.pop();
		System.out.println("Peeked data : " + q.peek());	//6
		
		
		
	}

}
