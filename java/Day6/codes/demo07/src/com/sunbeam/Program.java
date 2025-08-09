package com.sunbeam;

public class Program {
	public static void main1(String[] args) {
		//A thread-safe, mutable sequence of characters. 
		//A string buffer is like a String, but can be modified
		StringBuffer sb = new StringBuffer(); 
		sb.append("Nilesh"); //string 
		sb.append(40); // int 
		sb.append('M'); //char 
		sb.append(75.45); //double 
		
		String str = sb.toString(); 
		System.out.println("str : "+str);
	}
	public static void main2(String[] args) {
		StringBuffer sb = new StringBuffer(); 
		System.out.printf("Length : %d Capacity : %d\n",sb.length(),sb.capacity());
		sb.append("0123456789"); 
		System.out.printf("Length : %d Capacity : %d\n",sb.length(),sb.capacity());
		sb.append("ABCDEF"); 
		System.out.printf("Length : %d Capacity : %d\n",sb.length(),sb.capacity());
		sb.append("GHIJKL"); 
		System.out.printf("Length : %d Capacity : %d\n",sb.length(),sb.capacity());
	}
	public static void main3(String[] args) {
		String str = "Sunbeam"; 
		StringBuffer sb = new StringBuffer(str); 
		sb.reverse(); 
		String s = sb.toString(); 
		System.out.println("s : "+s);
	}
	public static void main4(String[] args) {
		StringBuffer sb1 = new StringBuffer("Sunbeam"); 
		StringBuffer sb2 = new StringBuffer("Sunbeam"); 
		System.out.println("sb1 == sb2 : " + (sb1 == sb2));
		System.out.println("sb1 == sb2 : " + sb1.equals(sb2));
	}
	public static void main5(String[] args) {
		// StringBuffer (since Java 1.0) is thread-safe.
		// Internally uses synchronization objects, which slow down the execution.
		// StringBuilder (since Java 5.0) is not thread-safe.
		//Not using synchronization objects, due to which it is faster than StringBuffer.
		// StringBuilder methods are same as StringBuffer methods.
		StringBuilder sb1 = new StringBuilder("Sunbeam"); 
		sb1.reverse(); 
		String str = sb1.toString(); 
		System.out.println("Str : "+str);
	}
	public static void main6(String[] args) {
		class Box{
			private int length; 
			private int breadth;
			private int height;
			public Box(int length, int breadth, int height) {
				
				this.length = length;
				this.breadth = breadth;
				this.height = height;
			}
			/* 
			//creating string with string concatenation is not efficient( space and time)
			@Override
			public String toString() {
				return "Box [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
			}*/ 
			//// more efficient than string concatenation 
			//-- String.format() since Java 5.0
			
			/* 
			@Override
			public String toString() {
				return String.format("Length : %d Breadth : %d Height : %d",this.length,this.breadth,this.height);
			}*/ 
			// more efficient than string concatenation -- Since Java 1.0
			/* 
			@Override
			public String toString() {
				StringBuffer sb = new StringBuffer(); 
				sb.append("Length : "); 
				sb.append(this.length); 
				sb.append("Breadth : "); 
				sb.append(this.breadth); 
				sb.append("Height : "); 
				sb.append(this.height); 
				
				return sb.toString(); 
			}*/ 
			//// more efficient than StringBuffer -- Since Java 5.0
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder(); 
				
				String str = 
						sb.append("Length : ")
						.append(this.length)
						.append(", Breadth : ")
						.append(this.breadth)
						.append(", Height : ")
						.append(this.height)
						.toString(); 
				return str; 
							
			}
			
			
		}
		Box b1 = new Box(10, 10, 10); 
		System.out.println("b1 :" + b1.toString());
		
	}
	public static void main(String[] args) {
		String str = "Sunbeam"; 
		StringBuffer sb1 = new StringBuffer("Sunbeam"); 
		//System.out.println("sb1 == str" + sb1 == str);
		System.out.println("str.equals(sb1) : " + str.equals(sb1.toString()));
	}
}






