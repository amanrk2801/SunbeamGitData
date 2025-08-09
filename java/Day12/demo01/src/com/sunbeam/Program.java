package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
	
	/* 
	public static void main(String[] args) {
		Double[] arr = {1.1,2.1,3.1,4.1,5.1,6.1,7.1,8.1}; 
		
		Stream<Double> strm = Arrays.stream(arr); 
		
		strm
		.skip(3)
		.limit(7)
		.forEach(e -> System.out.println(e));
		
	}*/ 
	/* 
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>( ); 
		list.add("A sequence of elements supporting sequential and parallel aggregate operations.");
		list.add("In addition to Stream, which is a stream of object references, there are primitive specializations for IntStream.");
		list.add("To perform a computation, stream operations are composed into a stream pipeline.");	
		
		Stream<String> strm = list.stream(); 
		
		strm
		.map(word -> word.toUpperCase())
		.flatMap(line -> Arrays.stream(line.split(" ")))
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>( );
		Collections.addAll(set, 1,2,3,4,5,6,7,8,9,10); 
		Stream<Integer> strm = set.stream(); 
		
		//Integer res = strm.reduce(0, (a,i) -> a + i);
		
		Integer res = strm.reduce(0, (a,i) -> {
			System.out.println(" a " + a + " i " + i);
			return a + i; 
		});
		System.out.println("res : " + res);
	}*/ 
	/* 
	public static void main(String[] args) {
		int num = 5; 
		Stream<Integer> strm = Stream.iterate(1, i -> i + 1).limit(10); 
		
		strm
		.map(i -> i * num)
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		//Returns an infinite sequential unordered stream
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)).limit(10); 
		
		strm
		.distinct()
		.forEach(e -> System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		//Returns an infinite sequential unordered stream
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)).limit(10); 
		
		List<Integer> list = strm
		.distinct()
		.collect(Collectors.toList()); 
		
		System.out.println(list);
	}*/ 
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		//Returns an infinite sequential unordered stream
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)).limit(10); 
		
		Set<Integer> set = strm
		.distinct()
		.collect(Collectors.toSet()); 
		
		System.out.println(set);
	}*/ 
	public static void main(String[] args) {
		//Wrapper 
		//Stream<Integer> strm = Stream.iterate(0, i -> i + 1);
		//Stream<int> strm = Stream.iterate(0, i -> i + 1); // ERROR 
		//primitive streams are more efficient 
		//-- because no boxing/unboxing done for each arithmetic
		
		//IntStream strm = IntStream.iterate(1, i -> i + 1).limit(10);
		//int res = strm.reduce(0, (a,i) -> a + i); 
		//System.out.println("res : "+res);
	
		 IntStream strm = IntStream.of(1,2,3,4,5); 
		 //strm
		 //.forEach(e -> System.out.println(e));
		 int res = strm.reduce(0, (a,i) -> a + i); 
		 System.out.println("res : "+res);
	}

	
	
	
}









