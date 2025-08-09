package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements AutoCloseable,StudentDao {
	
	private Connection con; 
	
	public StudentDaoImpl() throws Exception{
		con = Dbutil.getConnection(); 
	}
	
	@Override
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Student findByID(int roll) throws Exception {
		String sql = "SELECT * FROM students WHERE roll = ?"; 
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, roll); 
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					int rollNum = rs.getInt("roll"); 
					String name = rs.getString("name"); 
					double marks = rs.getDouble("marks"); 
					Student s = new Student(rollNum, name, marks); 
					return s; 
				}
			}//rs.close() ;
		}
		return null;
	}

	@Override
	public List<Student> findAll() throws Exception {
		List<Student> list = new ArrayList<Student>( );  
		String sql = "SELECT * FROM students"; 
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int rollNum = rs.getInt("roll"); 
					String name = rs.getString("name"); 
					double marks = rs.getDouble("marks");
					Student s = new Student(rollNum, name, marks); 
					list.add(s); 
				}
			}//rs.close(); 
		}
		return list; 
	}

	@Override
	public int save(Student s) throws Exception {
		int count; 
		String sql = "INSERT INTO students VALUES(?,?,?)"; 
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, s.getRoll());
			stmt.setString(2, s.getName());
			stmt.setDouble(3, s.getMarks());
			count = stmt.executeUpdate(); 
		}
		return count;
	}

	

}
