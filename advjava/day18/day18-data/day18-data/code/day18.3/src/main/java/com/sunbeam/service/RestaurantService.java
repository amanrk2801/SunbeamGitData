package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RestaurantDTO;
import com.sunbeam.dto.RestaurantMenuDTO;
import com.sunbeam.entities.Restaurant;

public interface RestaurantService {
//list available restaurants
	List<RestaurantDTO> getAvailableRestaurants();

	ApiResponse deleteDetails(Long id);

	ApiResponse addNewRestaurant(AddRestaurantDTO dto);

	RestaurantDTO getRestaurantDetails(Long id);
	
	ApiResponse updateRestaurant(Long id,AddRestaurantDTO dto);
	
	RestaurantMenuDTO getCompleteDetails(Long restaurantId);
}
