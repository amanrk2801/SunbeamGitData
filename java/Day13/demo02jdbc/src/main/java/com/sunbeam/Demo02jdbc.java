package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Demo02jdbc {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	public static final String DB_URl = "jdbc:mysql://localhost:3306/test"; 
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "manager";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in); 
	   try(Connection con = DriverManager.getConnection(DB_URl, DB_USER, DB_PASSWORD)){
		   //Creates a Statement object for sending SQL statements to the database
		   try(Statement stmt = con.createStatement()){
			   System.out.print("Enter the roll : ");
			   int roll = sc.nextInt(); 
			   System.out.print("Ente the name : ");
			   String name = sc.next(); 
			   System.out.print("Enter the marks : ");
			   double marks = sc.nextDouble(); 
			   String sql = "INSERT INTO students VALUES("+roll+",'"+name+"',"+marks+")";
			   int count = stmt.executeUpdate(sql); 
			   System.out.println("Rows affected : "+count);
		   }//stmt.close(); 
	   }//con.close(); 
	   catch (Exception e) {
		e.printStackTrace();
	}
	}
}
