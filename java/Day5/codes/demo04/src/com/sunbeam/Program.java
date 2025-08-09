package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		Date dt1 = new Date(1, 1, 2020); 
		Date dt2 = new Date(1, 1, 2020);
		
		boolean flag = dt1 == dt2; 
		//System.out.println("Res  : "+flag);
		
		//flag = dt1.equals(dt2); // when we dont override object class equals method 
		// is called , it compares the references 
		//System.out.println("Res :" +flag);
		
		flag = dt1.equals(dt2); 
		//System.out.println("Res :" +flag);
		
		//flag = dt1.equals(null);
		//System.out.println("Res :" +flag);
		
		//flag = dt1.equals(dt1); 
		//System.out.println("Res :" +flag);
		
		//flag = dt1.equals("27-03-2025"); 
		System.out.println("Res :" +flag);
	}

}
