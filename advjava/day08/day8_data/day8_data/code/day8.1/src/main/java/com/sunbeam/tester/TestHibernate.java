package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtils;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory()) {
			/*Calling static method of HibernateUtils class
			 * -> class loading
			 * -> static init block
			 * -> build singleton instance of SF
			 */
			System.out.println("hibernate up n running .....");
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
