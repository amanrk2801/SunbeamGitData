package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.FoodItemDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.FoodItemDTO;
import com.sunbeam.dto.RestaurantRespDTO;
import com.sunbeam.entities.FoodItem;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
	// depcy
	private final FoodItemDao foodItemDao;
	private final ModelMapper modelMapper;
	private final RestaurantClient restaurantClient;

	@Override
	public ApiResponse addFoodItemToRestaurant(Long restaurantId, FoodItemDTO dto) {
		// 1. Make MS call: RestaurantMenu -> RestaurantService (validate if
		// restaurant exists) - using OpenFeign lib.
		RestaurantRespDTO restaurantRespDTO = restaurantClient.getRestaurantDetails(restaurantId);
		//=> restaurant exists
		// 1.5  add validation rule - for dup checking
		if(foodItemDao.existsByItemNameAndRestaurantId(dto.getItemName(), restaurantId))
			throw new ApiException("Dup food item name n restaurnat id !!!!!");
		// restaurantEntity : persistent
		// 2. map food item dto -> entity
		FoodItem foodItemEntity = modelMapper.map(dto, FoodItem.class);
		foodItemEntity.setRestaurantId(restaurantId);
		//save
		foodItemDao.save(foodItemEntity);
		return new ApiResponse("New food item added to the restaurant");
	}

	@Override
	public List<FoodItemDTO> getRestaurantMenu(Long restaurantId) {
		// invoke dao's method
		return foodItemDao.findByRestaurantId(restaurantId)
				.stream()
				.map(entity -> modelMapper.map(entity, FoodItemDTO.class))
				.toList();
	}
	

}
