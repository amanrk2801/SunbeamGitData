package com.sunbeam;
class Chair{
	private int height , weight; // instance variable / fields 
	private static int price = 300;// field init 
	
	public Chair() {
		// TODO Auto-generated constructor stub
	}

	public Chair(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		Chair.price = price;
	}

	public void display( ) {
		//System.out.printf("Height : %d\nWeight :%d\nPrice : %d\n",this.height,this.weight,this.price); // Misleading /not readable
		System.out.printf("Height : %d\nWeight :%d\nPrice : %d\n",this.height,this.weight,Chair.price); // Misleading /not readable
	}
	
	
}
public class Program {
	public static void main(String[] args) {
		Chair c1 = new Chair(10, 20); 
		Chair c2 = new Chair(30, 40);
		
		c1.display();
		System.out.println();
		c2.display();
//In java we can access static members using object but not recommended , not -readable , misleading   
		//c1.price = 100; 
		//Chair.price =500;// price is private cannot be accessed outside the class  
		System.out.println();
		Chair.setPrice(500);
		//c1.display();
		//c2.display();
		
		System.out.println("Updated price : "+Chair.getPrice());
	}
}




