package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.InvalidInputException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.FoodItemDao;
import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.FoodItemDTO;
import com.sunbeam.entities.FoodItem;
import com.sunbeam.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
	private final FoodItemDao foodItemDao;
	private final RestaurantDao restaurantDao;
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addFoodItemToRestaurant(Long restaurantId, FoodItemDTO dto) {
		// 1. get restaurant by its id
		Restaurant restaurant = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found !!!!"));
		// 2. check for composite unique constraint - same restaurant id n food item
		// name
		if (foodItemDao.existsByMyRestaurantIdAndItemName(restaurantId, dto.getItemName()))
			throw new InvalidInputException("Same restaurant id n name already exists !!!!!");
		// 3 . valid -> map food item dto -> entity
		FoodItem foodItemEntity = modelMapper.map(dto, FoodItem.class);
		// 4. establish Restaurant <----> FoodItem : bi dir association
		restaurant.addFoodItem(foodItemEntity);
		// 5. no need of explictly calling save - due to cascadeType.ALL
		return new ApiResponse("added food item to the restaurant");
	}

	@Override
	public ApiResponse deleteFoodItemFromRestaurant(Long restaurantId, Long foodItemId) {
		// 1. get restaurant by its id
		Restaurant restaurant = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found !!!!"));
		// 2. get food item
		FoodItem item=foodItemDao.findById(foodItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Food item doesn't exist!!!!"));
		//3. => restaurant n food item - both exist
		restaurant.removeFoodItem(item);
		//due to orphanRemoval -true , child record will be deleted upon commit
		return new ApiResponse("deleted food item !!!!!");
	}

}
