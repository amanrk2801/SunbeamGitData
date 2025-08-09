package com.sunbeam;


public class Program {

	public static void main(String[] args) {
		Shape[] arr = {
				new Rectangle(10, 2),
				new Circle(4.1),
				new Square(5.1)
		}; 
		//double totalArea = Shapes.calcTotalArea(arr);
		//double totalArea = Shape.calcTotalArea(arr);
		//System.out.println("area : " + totalArea);
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println("CalcPeri : "+arr[i].calcPeri());
		}
	}
	

}
