package com.sunbeam;

import java.util.HashSet;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		//Box b1 = new Box( ); 
		//System.out.println("HashCode : "+b1.hashCode());
		Set<Box> set = new HashSet<Box>( );
		set.add(new Box(1, 1, 1));
		set.add(new Box(1, 1, 1));
		set.add(new Box(1, 1, 1));
		set.add(new Box(1, 1, 1));
		
		System.out.println("size : "+set.size());
	}
}
