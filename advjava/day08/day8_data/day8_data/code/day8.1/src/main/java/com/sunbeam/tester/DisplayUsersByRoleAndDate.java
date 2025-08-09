package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class DisplayUsersByRoleAndDate {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			UserDao dao=new UserDaoImpl();
			
			System.out.println("Enter user role n date(dob) ");
			//2. call dao's method
			dao.getUserDetailsByRoleAndDate(
					UserRole.valueOf(sc.next().toUpperCase()),
					LocalDate.parse(sc.next())
					)
			.forEach(user ->System.out.println(user));
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
