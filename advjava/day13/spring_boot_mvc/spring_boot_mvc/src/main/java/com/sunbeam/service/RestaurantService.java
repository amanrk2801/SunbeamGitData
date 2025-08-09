package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Restaurant;

public interface RestaurantService {
//list available restaurants
	List<Restaurant> getAvailableRestaurants();
}
