package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}
	
	private final int SIZE;
	private List<Entry> arr[];
	public HashTable(int size) {
		SIZE = size;
		arr = new List[SIZE];
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = new LinkedList<HashTable.Entry>();
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot corresponding to the given key
		int slot = h(key);
		
		//2. if key already exist then update its older value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(key == e.key) {
					e.value = value;
					return;
				}
			}
		}		
		
		//3. create an entry and add it on derived slot
		Entry e = new Entry(key, value);
		arr[slot].add(e);
	}
	
	public String get(int key) {
		//1. find slot corresponding to the given key
		int slot = h(key);
		
		//2. search key in linked list of slot and return its value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(key == e.key) {
					return e.value;
				}
			}
		}		
		
		//3. if key not found
		return null;
	}

}

















