package com.sunbeam;

import java.util.Objects;

public class Box {
	private int length; 
	private int breadth; 
	private int height;
	public Box() {
		// TODO Auto-generated constructor stub
	}
	public Box(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(breadth, height, length);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Box))
			return false;
		Box other = (Box) obj;
		return breadth == other.breadth && height == other.height && length == other.length;
	}
	@Override
	public String toString() {
		return "Box [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	} 
	
}
