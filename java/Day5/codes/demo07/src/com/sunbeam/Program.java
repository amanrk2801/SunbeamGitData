package com.sunbeam;
interface Printable{
	/*public static final*/int number = 10; 
	/*public abstract*/void print(); 
}
class Test implements Printable{

	@Override
	public void print() {
		System.out.println("Number :" + Printable.number);
	}
	
}
public class Program {

	public static void main(String[] args) {
		//Test t1 = new Test(); 
		//t1.print();
		Printable p = new Test(); // Polymorphic declaration 
		p.print();
	}

}
