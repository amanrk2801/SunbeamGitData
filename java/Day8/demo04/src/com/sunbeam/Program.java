package com.sunbeam;

class Fraction implements Comparable{
	private int n; 
	private int d;
	public Fraction(int n, int d) {
		this.n = n;
		this.d = d;
	} 
	private double value( ) {
		return (double)n/d; 
	}
	//this = f1 
	@Override
	public int compareTo(Object obj) {
		Fraction other = (Fraction) obj; 
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
		int res = f1.compareTo("10/2");  
		System.out.println("res : "+res); 
	}

}
