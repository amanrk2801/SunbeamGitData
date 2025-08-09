package com.sunbeam;

class Fraction implements Comparable<Fraction>{
	private int n; 
	private int d;
	public Fraction(int n, int d) {
		this.n = n;
		this.d = d;
	} 
	private double value( ) {
		return (double)n/d; 
	}
	@Override
	public int compareTo(Fraction other) {
		if(this.value() == other.value())
			return 0; 
		if(this.value() > other.value())
			return 1; 
		else 
			return -1; 
	}
	
	
}

public class Program {
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(10, 2); 
		Fraction f2 = new Fraction(20, 2); 
		int res = f1.compareTo(f2);  // type-safety at compile time 
		System.out.println("res : "+res); 
	}

}
