package com.sunbeam;

public class Program {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); 
		Singleton s2 = Singleton.getInstance(); 
		
		if(s1 == s2)
			System.out.println("Same");
		else 
			System.out.println("not same");
	}

}
