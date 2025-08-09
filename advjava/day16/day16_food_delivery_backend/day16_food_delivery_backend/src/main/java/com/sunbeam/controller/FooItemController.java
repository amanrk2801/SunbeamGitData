package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.FoodItemDTO;
import com.sunbeam.service.FoodItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/food_items")
@AllArgsConstructor
public class FooItemController {
	//depcy
	private final FoodItemService foodItemService;
	
	/*
	 * Desc - Add new food item to existing restaurant
	 * URL - http://host:port/food_items/{restaurantId} 
	 * Method - POST
	 * Payload - JSON representation of food item DTO -> @RequestBody 
	 * Success Resp -SC  201 + ApiResponse with success mesg
	 *  Error resp - SC 400 ,ApiReposnse with error mesg
	 */
	@PostMapping("/{restaurantId}")
	public ResponseEntity<?> addNewFoodItem(@PathVariable Long restaurantId,
			@RequestBody FoodItemDTO dto)
	{
		System.out.println("in add food item "+restaurantId+" "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(foodItemService.addFoodItemToRestaurant(restaurantId, dto));
	}
	
	/*
	 * Desc - (Hard) Delete specific food item from specified restaurant
	 * URL - http://host:port/food_items/{foodItemId}/restaurant/{restaurantId} 
	 * Method - POST
	 * Payload - JSON representation of food item DTO -> @RequestBody 
	 * Success Resp -SC  201 + ApiResponse with success mesg
	 *  Error resp - SC 400 ,ApiReposnse with error mesg
	 */
	@PostMapping("/{foodItemId}/restaurant/{restaurantId}")
	public ResponseEntity<?> addNewFoodItem(@PathVariable Long foodItemId,
			@PathVariable Long restaurantId)
	{
		System.out.println("in del food item "+restaurantId+" "+foodItemId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(foodItemService.deleteFoodItemFromRestaurant(restaurantId, foodItemId));
	}


}
