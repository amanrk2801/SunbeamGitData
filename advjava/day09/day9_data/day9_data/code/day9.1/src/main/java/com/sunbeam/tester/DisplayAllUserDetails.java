package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class DisplayAllUserDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				) {
			//1. create dao instance
			UserDao dao=new UserDaoImpl();			
			//2. call dao's method
			dao.getAllUserDetails()
			.forEach(user -> System.out.println(user));
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
