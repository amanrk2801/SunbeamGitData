package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.entities.Restaurant;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestRestaurantDao {
	@Autowired
	private RestaurantDao restaurantDao;

	@Test //method level annotation to declare test case
	void testGetRestaurantAndMenu() {
		Restaurant restaurant 
		= restaurantDao.getRestaurantAndMenu(1l).get();
		//public static void assertEquals(Object expectedResult,Object actualResult)
		assertEquals(2, restaurant.getFoodItems().size());
	}

}
