package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class SaveImage {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter file name n path");
			String filePath=sc.nextLine();
			System.out.println("Enter user id");
			Long userId=sc.nextLong();
			// 2. call dao's method
			System.out.println(dao.saveImage(userId,filePath));
		} /*
			 * JVM calls - sf.close() => DBCP is closed
			 */
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
