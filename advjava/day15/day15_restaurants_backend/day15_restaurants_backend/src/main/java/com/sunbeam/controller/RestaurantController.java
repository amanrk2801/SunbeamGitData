package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Restaurant;
import com.sunbeam.service.RestaurantService;

@RestController // =@Controller - cls level +@ResponseBody - ret type of methods
@RequestMapping("/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	/*
	 * Desc - Get all available restaurants URL - http://host:port/restaurants
	 * Method - GET Payload - none Successful Resp -SC 200 , body - List<Resaturant>
	 * Empty list - SC 204 , no body content
	 */
	@GetMapping
	public ResponseEntity<?> getAllAvailableRestaurants() {
		System.out.println("in get all");
		List<Restaurant> restaurants = restaurantService.getAvailableRestaurants();
		if (restaurants.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT)// 204
					.build();
		// => non empty list
		return ResponseEntity.ok(restaurants);// SC 200 , list
	}

	/*
	 * Method rets @ResponseBody List<Restaurant> -> D.S Spring boot has chosen by
	 * default - Jackson as a 3rd party vendor for serial(Java -> JSON | XML) n
	 * de-serial(JSON|XML -> Java) While sending the resp -> ResponseBody -> Java->
	 * JSON (json array) -> REST client
	 */
	/*
	 * Desc - Add new restaurant 
	 * URL - http://host:port/restaurants 
	 * Method - POST
	 * Payload - JSON representation of Restaurant -> @RequestBody 
	 * Success Resp -SC  201 + ApiReposnse with success mesg
	 *  Error resp - SC 400 ,ApiReposnse with error mesg
	 */
	@PostMapping
	public ResponseEntity<?> addRestaurant(@RequestBody 
			Restaurant newRestaurant) {
		System.out.println("in add " + newRestaurant);
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)//SC 201
					.body(restaurantService.addNewRestaurant(newRestaurant));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST) //SC 400
					.body(new ApiResponse(e.getMessage()));
		}
	}
}
