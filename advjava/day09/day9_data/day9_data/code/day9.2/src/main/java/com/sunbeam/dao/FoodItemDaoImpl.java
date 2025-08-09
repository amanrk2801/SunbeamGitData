package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.FoodItem;
import com.sunbeam.entities.Restaurant;

public class FoodItemDaoImpl implements FoodItemDao {

	@Override
	public String addFoodItemToResturant(Long restaurantId, FoodItem foodItem) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get restaurant from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			
			if(restaurant != null)
			{
				//4. not null => valid restaurant id =>exists
				restaurant.addFoodItem(foodItem);
				//5. invoke persist
			//	session.persist(foodItem); - no longer required , since added cascading
				mesg="added new food item to the restaurant....";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String addFoodItemsToResturant(Long restaurantId, 
			List<FoodItem> foodItems) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get restaurant
			Restaurant restaurant=session.get(Restaurant.class, restaurantId);
			if(restaurant != null)
			{
				//establish bi dir between Restaurant - FoodItem
				foodItems.forEach(item -> restaurant.addFoodItem(item));
				mesg="mulitple food items added to restaurant";
			}					
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String removeFoodItem(Long restaurantId, Long foodItemId) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();// DML delete - food_item
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}

}
