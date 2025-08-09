package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("hibernate up n running !");

		} // sf.close() -> clean DBCP

	}

}
