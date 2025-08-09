package sunbeam.geometry;

import sunbeam.geometry.dim2.Circle;
import sunbeam.geometry.dim3.Box;
import sunbeam.geometry.dim3.Cylinder;

public class Program{
  public static void main(String[] args){
      Circle c = new Circle(3.1); 
      System.out.println("Area : "+c.calcArea()); 
      Cylinder c1 = new Cylinder(1.3,2.1); 
      System.out.println("Volume : "+c1.calcVolume()); 
      Box b1 = new Box(1.1,2.1,3.1);  
      System.out.println("Volume : "+b1.calcVolume()); 			 	
			
  } 
}