package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.FoodItemDao;
import com.sunbeam.dao.FoodItemDaoImpl;

public class RemoveFoodItemFromRestaurant {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)) {
			FoodItemDao dao=new FoodItemDaoImpl();
			System.out.println("Enter restaurant id n food item id");			
			System.out.println(dao.
					removeFoodItem(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
