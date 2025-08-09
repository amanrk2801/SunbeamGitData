package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;

public class Program {

	
	public static void main(String[] args) {
		Product[ ] arr = {
			new Product(3, "Pen", 11.33),
			new Product(4, "Pencil", 5.10),
			new Product(1, "Erasor", 6.66),
			new Product(5, "Sharpner", 7.33),
			new Product(2, "Book", 20.00)
	    }; 
		System.out.println("Before sorting :: ");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("After Sorting on ID :: ");
		
		class ProductNameComparator implements Comparator<Product>{
			@Override
			public int compare(Product x, Product y) {
				int diff = x.getName().compareTo(y.getName()); 
				return diff; 
			}
			
		}
		ProductNameComparator productNameComparator = new ProductNameComparator(); 
	
		Arrays.sort(arr, productNameComparator);
		
		System.out.println("Sorted on Name : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		class ProductPriceAscComparator implements Comparator<Product>{

			@Override
			public int compare(Product x, Product y) {
				int diff = Double.compare(x.getPrice(),y.getPrice()); 
				return diff; 
			}
			
		}
		Arrays.sort(arr, new ProductPriceAscComparator());
		
		System.out.println("Sorted on Price : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		class ProductPriceDescComparator implements Comparator<Product>{

			@Override
			public int compare(Product x, Product y) {
				int diff = (int) (y.getPrice() - x.getPrice()); 
				return diff; 
			}
			
		}
		
		Arrays.sort(arr, new ProductPriceDescComparator());
		
		System.out.println("Sorted on price :: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
