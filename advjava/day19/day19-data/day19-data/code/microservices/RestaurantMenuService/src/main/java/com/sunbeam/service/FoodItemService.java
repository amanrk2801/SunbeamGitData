package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.FoodItemDTO;

public interface FoodItemService {
	ApiResponse addFoodItemToRestaurant(Long restaurantId, FoodItemDTO dto);
	//get all food items by restaurant id
	List<FoodItemDTO> getRestaurantMenu(Long restaurantId);
}
