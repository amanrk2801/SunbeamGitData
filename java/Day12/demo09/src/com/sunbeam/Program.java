package com.sunbeam;

import java.util.Scanner;

enum ShapeType{
	EXIT , RECTANGLE , CIRCLE , SQUARE 
}
public class Program {
	public static ShapeType menuList( ) {
		Scanner sc = new Scanner(System.in); 
//		System.out.println("0.Exit");
//		System.out.println("1.Rectangle");
//		System.out.println("2.Circle");
//		System.out.println("3.Square");
		ShapeType[] shaVal = ShapeType.values(); 
		for (ShapeType sh : shaVal) {
			System.out.println(sh.ordinal() + "." + sh.name() );
		}
		System.out.println("Enter the choice : ");
		return shaVal[sc.nextInt()]; 
	}
	public static void main(String[] args) {
		ShapeType choice; 
		while((choice = menuList())!=ShapeType.EXIT) {
			switch (choice) {
			case RECTANGLE:
				System.out.println("Rectangle shape");
				break;
			case CIRCLE: 
				System.out.println("Circle Shape");
				break; 
			case SQUARE: 
				System.out.println("Square Shape");
				break; 
			default:
				System.out.println("Invalid Shape");
				break;
			}
		}

	}

}
