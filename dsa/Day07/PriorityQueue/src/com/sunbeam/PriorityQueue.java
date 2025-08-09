package com.sunbeam;

public class PriorityQueue {
	private Heap h;
	private int size;
	public PriorityQueue(int size) {
		this.size = size;
		h = new Heap(size);
	}
	
	public void push(int value) {
		h.add(value);
	}
	
	public int pop() {
		return h.delete();
	}
	
	public int peek() {
		return h.getRoot();
	}
	
	public boolean isEmpty() {
		return h.isEmpty();
	}
	
	public boolean isFull() {
		return h.isFull();
	}
	

}







