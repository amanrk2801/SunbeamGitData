package com.sunbeam.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/dacdb";
	private static final String DB_USER = "nilesh";
	private static final String DB_PASSWD = "nilesh";
	
	static {
		try {
			// load and register driver
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}
}
