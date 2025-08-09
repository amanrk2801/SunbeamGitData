package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class ChangePassword {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user email, old pwd, new pwd");
			// 2. call dao's method
			System.out.println(dao.changePassword(sc.next(),
					sc.next(), sc.next()));
		} /*
			 * JVM calls - sf.close() => DBCP is closed
			 */
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
