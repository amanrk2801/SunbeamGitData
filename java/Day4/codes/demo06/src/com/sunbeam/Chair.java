package com.sunbeam;

public class Chair {
	private int height , weight; 
	private static int price; 
	public Chair() {
		// TODO Auto-generated constructor stub
	}
	
	public Chair(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	static {
		price = 300; 
		System.out.println("static block - 1");
	}
	static {
		price = 400; 
		System.out.println("static block - 2");
	}
	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		Chair.price = price;
	}
	
}
