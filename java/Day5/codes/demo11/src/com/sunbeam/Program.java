package com.sunbeam;

import java.util.Scanner;

abstract class Shape{
	protected float area; 
	public abstract void acceptRecord( ); 
	public abstract void calculateArea( ); 
	public final void printRecord( ) {
		System.out.println("Area : "+this.area);
	}
}
class Rectangle extends Shape{
	private float length; 
	private float breadth; 
	@Override
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Length : ");
		length = sc.nextFloat(); 
		System.out.print("Breadth : ");
		breadth = sc.nextFloat(); 
	}
	@Override
	public void calculateArea() {
		this.area = this.length * this.breadth;  
	}
}
class Circle extends Shape{
	private float radius; 
	@Override
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("radius : ");
		this.radius = sc.nextFloat(); 
	}
	@Override
	public void calculateArea() {
		this.area = (float) (Math.PI * this.radius * this.radius); 
	}
}
public class Program {
	public static int menuList( ) {
		int choice; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("0.Exit");
		System.out.println("1.Rectangle");
		System.out.println("2.Circle");
		System.out.print("Enter the choice : ");
		choice = sc.nextInt(); 
		return choice; 
	}
	public static void main(String[] args) {
		int choice; 
		while((choice = menuList())!=0) {
			Shape shape = null; 
			switch (choice) {
			case 1:
				shape = new Rectangle(); //upcasting 
				break;
			case 2: 
				shape = new Circle(); //upcasting 
				break; 
			default:
				System.out.println("Invalid choice");
				break;
			}
			if(shape!=null) {
				shape.acceptRecord(); // dynamic method dispatch 
				shape.calculateArea();// dynamic method dispatch
				shape.printRecord();
			}
		}
	}
}



