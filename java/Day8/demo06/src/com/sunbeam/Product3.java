package com.sunbeam;

public class Product3 implements Comparable<Product3> {
	private int id; 
	private String name; 
	private double price; 
	public Product3() {
		// TODO Auto-generated constructor stub
	}
	public Product3(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("%-15s%-10d%10.2f",this.name,this.id,this.price); 
	}
	@Override
	public int compareTo(Product3 other) {
		int diff = this.name.compareTo(other.name); 
		return diff; 
	}
	
	
}
