package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.FoodItemDTO;
import com.sunbeam.service.FoodItemService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/food_items")
@AllArgsConstructor
public class FoodItemController {
	//depcy
	private final FoodItemService foodItemService;
	/*
	 * Add Food Item
      URL - http://host:port/food_items/{restaurantId}
      Method - POST
      Payload - food item dto - details
      error resp - ApiResp dto - SC 400 , mesg -adding food item failed
      success resp - ApiResp dto - SC 201 , success mesg
	 */
	@PostMapping("/{restaurantId}")
	@Operation(description = "Add new food item")
	public ResponseEntity<?> addFoodItem(@PathVariable 
			Long restaurantId, @RequestBody FoodItemDTO dto)
	{
		System.out.println(" in add food "+restaurantId+" "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body
				(foodItemService.addFoodItemToRestaurant
						(restaurantId, dto));
	}
	/*
	 * Get Food Items by restaurant id
      URL - http://host:port/food_items/{restaurantId}
      Method - GET
      Payload - none
      error resp - SC 404 
      success resp - list of dtos
	 */
	@GetMapping("/{restaurantId}")
	@Operation(description = "Get Food Items by restaurant id")
	public ResponseEntity<?> getRestaurantMenu(@PathVariable Long restaurantId)
	{
		System.out.println("in get "+restaurantId);
		return ResponseEntity.ok(
				foodItemService.getRestaurantMenu(restaurantId));
	}

}
