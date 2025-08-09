package com.sunbeam;

/*
interface Printable {
	void show();
}
interface Displayable {
	void show();
}
// multiple interface inheritance will not lead to any ambiguity error
// because interfaces doesn't contain any definitions
class MyClass implements Printable, Displayable {
	@Override
	public void show() {
		System.out.println("MyClass.show() called.");
	}
}

public class Program02 {
	public static void main(String[] args) {
		MyClass obj1 = new MyClass();
		obj1.show();
		Printable obj2 = new MyClass();
		obj2.show();
		Displayable obj3 = new MyClass();
		obj3.show();
	}
}
*/
/*
// Java 8 allows method implementation (default) in interfaces
interface Printable {
	default void show() {
		System.out.println("Printable.show() called.");
	}
}
interface Displayable {
	default void show() {
		System.out.println("Displayable.show() called.");
	}
}
// compiler error: duplicate show() method in FirstClass.
// if two interfaces have default method with same signature and a class is inherited from that interface,
// 	then it will lead to ambiguity.
class FirstClass implements Printable, Displayable {
	
}

public class Program02 {
	public static void main(String[] args) {
		
	}
}
*/

/*
interface Printable {
	default void show() {
		System.out.println("Printable.show() called.");
	}
}
interface Displayable {
	default void show() {
		System.out.println("Displayable.show() called.");
	}
}
// if two interfaces have default method with same signature and a class is inherited from that interface,
//	then it will lead to ambiguity.
// this problem can be resolved by overriding method in sub-class.
class SecondClass implements Printable, Displayable {
	public void show() {
		System.out.println("SecondClass.show() called.");
	}
}
public class Program02 {
	public static void main(String[] args) {
		SecondClass obj1 = new SecondClass();
		obj1.show();
		Printable obj2 = new SecondClass();
		obj2.show();
		Displayable obj3 = new SecondClass();
		obj3.show();		
	}
}
*/

/*
class Printable {
	public void show() {
		System.out.println("Printable.show() called.");
	}
}
interface Displayable {
	default void show() {
		System.out.println("Displayable.show() called.");
	}
}
// when same signature method is inherited from a super-class
// and a super-interface, the super-class method gets precedance.
// no compiler error for ambiguity
class ThirdClass extends Printable implements Displayable {
}
public class Program02 {
	public static void main(String[] args) {
		ThirdClass obj1 = new ThirdClass();
		obj1.show();
		Printable obj2 = new ThirdClass();
		obj2.show();
		Displayable obj3 = new ThirdClass();
		obj3.show();		
	}
}
*/
/*
class Printable {
	public void show() {
		System.out.println("Printable.show() called.");
	}
}
interface Displayable {
	default void show() {
		System.out.println("Displayable.show() called.");
	}
}
// method overrriding -- method is called depending on type of object.
class FourthClass extends Printable implements Displayable {
	public void show() {
		System.out.println("FourthClass.show() called.");
	}
}
public class Program02 {
	public static void main(String[] args) {
		FourthClass obj1 = new FourthClass();
		obj1.show();
		Printable obj2 = new FourthClass();
		obj2.show();
		Displayable obj3 = new FourthClass();
		obj3.show();		
	}
}
*/

interface Printable {
	default void show() {
		System.out.println("Printable.show() called.");
	}
}
interface Displayable {
	default void show() {
		System.out.println("Displayable.show() called.");
	}
}
// method overrriding -- method is called depending on type of object.
class FourthClass implements Printable, Displayable {
	public void show() {
		System.out.println("FourthClass.show() called.");
		// default methods in super interface can be called from sub-class methods
		//super.show(); // error: show() is not found in super-class i.e. Object
		Printable.super.show();
		Displayable.super.show();
	}
}
public class Program02 {
	public static void main(String[] args) {
		FourthClass obj1 = new FourthClass();
		obj1.show();
	}
}