package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dao.RestaurantDaoImpl;
import com.sunbeam.entities.Restaurant;
public class DeleteRestuarantDetails {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			//create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant name , to delete details");
			
			System.out.println(dao.deleteResturant(sc.next()));
		}
	}

}
