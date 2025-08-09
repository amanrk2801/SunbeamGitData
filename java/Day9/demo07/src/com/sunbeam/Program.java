package com.sunbeam;

import java.util.Stack;

public class Program {

	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<Integer>( );
		
		stk.push(10); 
		stk.push(20); 
		stk.push(30); 
		stk.push(40);
		
		System.out.println("Top-most ele " + stk.peek());
		
		while(!stk.empty()) {
			Integer ele = stk.pop();
			System.out.println(ele);
		}

	}

}
