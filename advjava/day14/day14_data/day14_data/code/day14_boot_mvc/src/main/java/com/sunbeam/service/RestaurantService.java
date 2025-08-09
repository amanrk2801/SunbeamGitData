package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Restaurant;

public interface RestaurantService {
//list available restaurants
	List<Restaurant> getAvailableRestaurants();

	String deleteDetails(Long id);

	String addNewRestaurant(Restaurant transientRestaurant);

	Restaurant getRestaurantDetails(Long id);
	
	String updateRestaurant(Long id,Restaurant restaurant);
}
