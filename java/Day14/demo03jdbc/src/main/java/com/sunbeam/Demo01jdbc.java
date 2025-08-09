package com.sunbeam;

import java.net.ConnectException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Demo01jdbc {
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
	
	// Ip a id1 (src account ) , id2(dest accont) , ammount  
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in); 
		Connection con = null; 
		try {
			con = DriverManager.getConnection(DB_URl, DB_USER, DB_PASSWORD); 
			con.setAutoCommit(false);
			
			System.out.print("Enter the src Account id : ");
			int id1 = sc.nextInt(); 
			System.out.print("Enter the dest Account id : ");
			int id2 = sc.nextInt();
			System.out.print("Enter the ammount : ");
			double ammount = sc.nextDouble(); 
			
			String sql1 = "UPDATE accounts SET balance = balance - ? WHERE id = ?"; 
			PreparedStatement stmt1 = con.prepareStatement(sql1); 
			stmt1.setDouble(1, ammount);
			stmt1.setInt(2, id1);
			int count1 = stmt1.executeUpdate(); 
			
			String sql2 = "UPDATE accounts SET balance = balance + ? WHERE id = ?"; 
			PreparedStatement stmt2 = con.prepareStatement(sql2); 
			stmt2.setDouble(1, ammount); 
			stmt2.setInt(2, id2);
			int count2 = stmt2.executeUpdate(); 
			
			if(count1!=1 || count2!=1)
				throw new RuntimeException("Transaction failure"); 
			else 
				System.out.println("Transaction successful ");
			con.commit(); 
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				if(con!=null)
				  con.rollback(); 	
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}









