package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class GetUserDetailsById {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			
			System.out.println("Enter user id ");
			//2. call dao's method
			System.out.println(dao.getUserDetailsById(sc.nextLong()));
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
