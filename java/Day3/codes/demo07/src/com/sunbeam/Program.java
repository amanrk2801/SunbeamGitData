package com.sunbeam;


public class Program {
	public static void main(String[] args) {
		Human[] arr = new Human[4]; 
		
		arr[0] = new Human(31, 78, 160); 
		arr[1] = new Human(33, 74, 152); 
		arr[2] = new Human(29, 71, 176); 
		arr[3] = new Human(27, 79, 179);
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i].display();
		}
	}

}



