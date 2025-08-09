package com.sunbeam;

import java.util.Scanner;

class Shape{
	protected float area; 
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	public float getArea() {
		return area;
	}
	public void calculateArea( ) {
		//TODO 
	}
	public void printRecord( ) {
		System.out.println("Area : "+area);
	}
}
class Rectangle extends Shape{
	private float length; 
	private float breadth; 
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	public void setLength(float length) {
		this.length = length;
	}
	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}
	@Override
	public void calculateArea() {
		this.area = this.length * this.breadth; 
	}
	
}
class Circle extends Shape{
	private float radius; 
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	@Override
	public void calculateArea() {
		this.area = (float) (Math.PI * this.radius * this.radius); 
	}
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	public static int menuList( ) {
		int choice; 
		 
		System.out.println("0.Exit");
		System.out.println("1.Rectangle");
		System.out.println("2.Circle");
		System.out.print("Enter the choice : ");
		choice = sc.nextInt(); 
		return choice; 
	}
	public static void acceptRecord(Shape shape) {
		if(shape instanceof Rectangle) {
			Rectangle rect = (Rectangle) shape;// downcasting 
			System.out.println("Length : ");
			rect.setLength(sc.nextFloat());
			System.out.println("Breadth : ");
			rect.setBreadth(sc.nextFloat());
		}
		else if(shape instanceof Circle) {
			Circle c = (Circle) shape;
			System.out.println("Radius : ");
			c.setRadius(sc.nextFloat());
		}
		else 
			System.out.println("Invalid shape");
	}
	public static void printRecord(Shape shape) {
		System.out.println("Area : "+shape.getArea()); 
	}
	public static void main(String[] args) {
		int choice; 
		while((choice = menuList())!=0) {
			Shape shape = null; 
			switch (choice) {
			case 1:
				shape = new Rectangle(); // upcasting 
				break;
			case 2: 
				shape = new Circle(); // upcasting 
				break; 
			default:
				System.out.println("Invalid choice");
				break;
			}
			if(shape!=null) {
				Program.acceptRecord(shape);
				shape.calculateArea(); // dynamic method dispatch 
				Program.printRecord(shape);
			}
		}
	}
}
