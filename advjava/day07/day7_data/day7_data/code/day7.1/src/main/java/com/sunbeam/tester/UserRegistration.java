package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class UserRegistration {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			
			System.out.println("Enter user details - firstName, "
					+ " lastName,  email,  password,  subscriptionAmount,\r\n"
					+ "			 userRole, dob");
			//2. create User instance
			User newUser=new User(sc.next(), sc.next(), sc.next(), 
					sc.next(), 
					sc.nextDouble(), 
					//string -> enum
					UserRole.valueOf(sc.next().toUpperCase()), 
					//string -> LocalDate
					LocalDate.parse(sc.next()));
			//3. call dao's method
			System.out.println(dao.registerUser(newUser));
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
