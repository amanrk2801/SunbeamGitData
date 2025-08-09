package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Program {
	
	/* 
	public static void main(String[] args) {
		// Vector (from 1.0) is Synchronized/Thread-safe (like StringBuffer)
		Vector<Integer> v = new Vector<Integer>( ); 
		System.out.printf("Capacity : %d Size : %d\n",v.capacity(),v.size());// 10 0 
		for(int i = 1 ; i<=10 ; i++)
			v.add(i); 
		System.out.printf("Capacity : %d Size : %d\n",v.capacity(),v.size());// 10 10
		v.add(11); 
		System.out.printf("Capacity : %d Size : %d\n",v.capacity(),v.size());// 20 11
		for(int i = 12 ; i<=20 ; i++)
		v.add(i); 	
		System.out.printf("Capacity : %d Size : %d\n",v.capacity(),v.size());// 20 20
		v.add(21); 
		System.out.printf("Capacity : %d Size : %d\n",v.capacity(),v.size());// 40 21
	}*/ 
	/* 
	public static void main(String[] args) {
		// ArrayList (from 1.2) is Non-Synchronized/Not Thread-safe (like StringBuilder)
		ArrayList<Integer> v = new ArrayList<Integer>( ); 
		System.out.printf("Size : %d\n",v.size()); //10 0
		for(int i = 1 ; i<=10 ; i++)
			v.add(i); 
		System.out.printf("Size : %d\n",v.size()); //10 10
		v.add(11); 
		System.out.printf("Size : %d\n",v.size()); //15 11
		for(int i = 12 ; i<=15 ; i++)
			v.add(i); 
		System.out.printf("Size : %d\n",v.size()); //15 15
		v.add(16); 
		System.out.printf("Size : %d\n",v.size()); //22 16
	}*/ 
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>( ); 
		List<Integer> list = Collections.synchronizedList(l); 
		// Collections.synchronizedList() creates a synchronization wrapper on given list
		// "list" is synchronized.
	}

}
