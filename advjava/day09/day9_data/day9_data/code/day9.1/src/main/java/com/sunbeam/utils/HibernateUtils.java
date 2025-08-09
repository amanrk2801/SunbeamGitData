package com.sunbeam.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		//1. Create empty Configuration class instance
		//2. Configure it - to populate it
		//3. Builds SF
		factory = new Configuration() //empty config
		.configure() //loaded with xml based props n mappings
		.buildSessionFactory();
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
