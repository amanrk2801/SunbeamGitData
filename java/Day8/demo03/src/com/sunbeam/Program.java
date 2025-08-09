package com.sunbeam;

class Fraction{
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
	public boolean equals(Object obj) {
		Fraction other = (Fraction) obj;
		if(this.value() == other.value())
			return true; 
		return false; 
	}
	
}

public class Program {
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(10, 2); 
		Fraction f2 = new Fraction(10, 2); 
		boolean res = f1.equals("f2"); 
		System.out.println("res : "+res); 
	}

}
