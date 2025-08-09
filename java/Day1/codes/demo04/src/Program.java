
public class Program {
	public static void main(String[] args) {
		//variable declaration 
		double length = 10.00 , breadth = 2.00 , area; 
		
		//area calculation 
		area = length * breadth; 
		
		//print the result 
		System.out.println("Area : " + area);
		System.out.println("Len : "+ length + " , Breadth : "+breadth + " , area : "+ area);
		System.out.printf("Area = %.2f",area);
	}
}
