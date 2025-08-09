package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.FoodItemDao;
import com.sunbeam.dao.FoodItemDaoImpl;
import com.sunbeam.entities.FoodItem;

public class AddNewFoodItemToRestaurant {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao
			FoodItemDao dao = new FoodItemDaoImpl();
			System.out.println(
					"Enter details - restaurant id , itemName, " 
			+ " itemDescription,  isVeg,  price");

			Long restaurantId = sc.nextLong();
			FoodItem foodItem = 
					new FoodItem(sc.next(), sc.next(), sc.nextBoolean(), sc.nextInt());
			System.out.println(dao.addFoodItemToResturant(restaurantId, foodItem));
		}
	}

}
