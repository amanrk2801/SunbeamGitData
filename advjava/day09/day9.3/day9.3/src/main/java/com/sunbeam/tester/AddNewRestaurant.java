package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dao.RestaurantDaoImpl;
import com.sunbeam.entities.Restaurant;
public class AddNewRestaurant {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			//create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant details -"
					+ " name,  address,  city,  description");
			Restaurant restaurant=new Restaurant(sc.next(), 
					sc.next(), sc.next(), sc.next());// restaurant - transient
			System.out.println(dao.addResturant(restaurant));
		}
	}

}
