package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")	
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
	 *Update  Food Item (admin only)
      URL - http://host:port/food_items/{foodItemId}
      Method - PUT
      Payload - food item dto - details to be updated
      error resp - ApiResp dto - SC 400 | 404 , mesg -updating food item failed
      success resp - ApiResp dto - SC 200 , success mesg
	 */
	@PutMapping("/{foodItemId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")	
	@Operation(description = "Update food item - can also apply discount")
	public ResponseEntity<?> updateFoodItem(@PathVariable 
			Long foodItemId,@RequestBody FoodItemDTO dto)
	{
		System.out.println(" in add food "+foodItemId+" "+dto);
		return ResponseEntity
				.ok(foodItemService.updateFoodItemDetails
						(foodItemId, dto));
	}

}
