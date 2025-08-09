package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Restaurant;

public interface RestaurantService {
//list available restaurants
	List<Restaurant> getAvailableRestaurants();

	ApiResponse deleteDetails(Long id);

	ApiResponse addNewRestaurant(Restaurant transientRestaurant);

	Restaurant getRestaurantDetails(Long id);
	
	ApiResponse updateRestaurant(Long id,Restaurant restaurant);
}
