package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
	/* 
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10}; 
		
		Stream<Integer> strm = Arrays.stream(arr); 
		
		strm
		.skip(3)
		.limit(7)
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("India is my Country"); 
		list.add("Sunbeam Pune and Karad"); 
		
		Stream<String> strm = list.stream(); 
		
		strm
		.map(word -> word.toUpperCase())
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		String[] names = {"Smita", "Rahul", "Rachana", "Amit", "Shraddha", "Nilesh", "Rohan", "Pradnya", "Rohan", "Pooja", "Lalita"};
		Stream<String> strm = Stream.of(names); 
		
		strm
		.filter(word -> word.endsWith("a"))
		.forEach(e -> System.out.println(e));
	}*/
	/* 
	public static void main(String[] args) {
		String[] names = {"Smita", "Rahul", "Rachana", "Amit", "Shraddha", "Nilesh", "Rohan", "Pradnya", "Rohan", "Pooja", "Lalita"};
		Stream<String> strm = Stream.of(names); 
		
		strm
		.sorted((x,y) -> y.compareTo(x))
		.forEach(e -> System.out.println(e));
	}*/
	/* 
	public static void main(String[] args) {
		String[] names = {"Smita", "Rahul", "Rachana", "Amit", "Shraddha", "Nilesh", "Rohan", "Pradnya", "Rohan", "Pooja", "Lalita"};
		Stream<String> strm = Stream.of(names); 
		
		strm
		.skip(2)
		.limit(4)
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		String[] names = {"Smita", "Smita", "Rachana", "Amit", "Shraddha", "Amit", "Rohan", "Pradnya", "Rohan", "Pooja", "Lalita"};
		Stream<String> strm = Stream.of(names); 
		
		strm
		.distinct()
		.forEach(e -> System.out.println(e));
	}*/
	public static void main(String[] args) {
		String[] names = {"Smita", "Smita", "Rachana", "Amit", "Shraddha", "Amit", "Rohan", "Pradnya", "Rohan", "Pooja", "Lalita"};
		Stream<String> strm = Stream.of(names); 
		
		long res = strm
		.count(); 
		
		System.out.println("res : "+res);
	}
}
