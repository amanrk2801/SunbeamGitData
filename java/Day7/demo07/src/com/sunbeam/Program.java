package com.sunbeam;

class Box<T>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	} 
	
}
public class Program {
	
	/* 
	public static void main(String[] args) {
		//? wild-card (Unbounded generic type references)
		Box<?> b1; //( ? is wildcard -- any type is okay while creating object)
		b1 = new Box<Integer>(); // OK 
		//b1 = new Box<Double>(); // OK 
		//b1 = new Box<String>(); //OK 
		//b1 = new Box<Object>(); //OK 
		b1.getObj(); //get returns  Object 
	}*/ 
	/* 
	public static void main(String[] args) {
	//(upper-bounded generic type references)
    //(any type is okay that is Number or inherited from Number)	
	  Box<? extends Number> b1;  
	  b1 = new Box<Integer>(); // OK ( Integer is a Number) 
	  //b1 = new Box<Number>(); // OK  ( Number) 
	  //b1 = new Box<String>(); // String is not a Number 
	  //b1 = new Box<Object>(); // Object is not a Number 
	  //b1.getObj(); // get returns Number    
	}*/ 
	
	/* 
	public static void main(String[] args) {
		//(lower-bounded generic type references) 
		//(any type is okay that is Number or its super-class)  	
	    Box<? super Number>b1;
	    //b1 = new Box<Integer>(); // Integer is not a super-class of Number 
	    //b1 = new Box<Object>(); // OK 
	    //b1 = new Box<String>(); // NOT OK (String is not a Super-class of Number) 
	      b1 = new Box<Number>(); // OK 
	      b1.getObj(); // get returns object 
	}*/ 
	
	
	//static methods 
	public static void printAnyBox(Box<?> b1) {
		Object obj = b1.getObj();
		System.out.println("obj : printAnyBox ----- " +obj);
	}
	public static void printNumberBox(Box<? extends Number> b1) {
		System.out.println("printNumberBox -----" + b1.getObj());
	}
	public static void printSuperNumberBox(Box<? super Number> b1) {
		System.out.println("printNumberBox -----" + b1.getObj());
	}
	public static void main(String[] args) {
		
		Box<String> b1 = new Box<String>(); 
		b1.setObj("Hello");
		
		Box<Integer> b2 = new Box<Integer>(); 
		b2.setObj(new Integer(12));
		
		Box<Number> b3 = new Box<Number>(); 
		b3.setObj(new Double(11.33));
		
		Box<Object> b4 = new Box<Object>(); 
		b4.setObj(new Object());
		
		//printAnyBox(b1);
		//printAnyBox(b2);
		//printAnyBox(b3);
		//printAnyBox(b4);
		  
		//printNumberBox(b1); // String is not a Number 
		//printNumberBox(b2); // OK 
		//printNumberBox(b3); // OK 
		//printNumberBox(b4); // Object is not a Number 
		 
		//printSuperNumberBox(b1);//String is not a super-class of Number 
		//printSuperNumberBox(b2);//Integer is not a super-class of Number  
		printSuperNumberBox(b3); // OK 
		printSuperNumberBox(b4); // Object is a super-class of Number 
		
		
	}

}


