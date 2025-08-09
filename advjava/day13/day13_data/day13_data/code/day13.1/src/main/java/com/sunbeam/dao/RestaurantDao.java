package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Restaurant;

public interface RestaurantDao {
//list all available restaurants
	List<Restaurant> getAvailableRestaurants();
}
