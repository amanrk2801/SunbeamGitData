package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dao.RestaurantDaoImpl;
import com.sunbeam.entities.Restaurant;

public class GetOrLoadRestaurantDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create Restaurant dao instance
			RestaurantDao dao = new RestaurantDaoImpl();
			System.out.println("Enter Restaurant id");
			Restaurant restaurant = dao.getOrLoadRestaurantDetails(sc.nextLong());
			System.out.println("Restaurant details ");
			System.out.println(restaurant);
		
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
