package com.sunbeam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.RestaurantDTO;
import com.sunbeam.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController // =@Controller - cls level +@ResponseBody - ret type of methods
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Validated
public class RestaurantController {   
	private final RestaurantService restaurantService;	

	/*
	 * Desc - Get all available restaurants 
	 * URL - http://host:port/restaurants
	 * Method - GET 
	 * Payload - none 
	 * Successful Resp -SC 200 , body - List<Resaturant>
	 * Empty list - SC 204 , no body content
	 */
	@GetMapping
	public ResponseEntity<?> getAllAvailableRestaurants() {
		System.out.println("in get all");
		List<RestaurantDTO> restaurants = 
				restaurantService.getAvailableRestaurants();
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
	 * Payload - JSON representation of Restaurant DTO -> @RequestBody 
	 * Success Resp -SC  201 + ApiResponse with success mesg
	 *  Error resp - SC 400 ,ApiReposnse with error mesg
	 */
	@PostMapping
	//method level access control rule - only admin user can add new restaurant
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addRestaurant(@RequestBody 
			AddRestaurantDTO newRestaurant) {
		System.out.println("in add " + newRestaurant);
		
			return ResponseEntity
					.status(HttpStatus.CREATED)//SC 201
					.body(restaurantService.addNewRestaurant(newRestaurant));

	}
	/*
	 * Desc - Soft delete a restaurant 
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - DELETE
	 * Payload - none
	 * Success Resp -SC  200 + ApiReposnse with success mesg
	 *  Error resp - SC 404 ,ApiReposnse with error mesg
	 */
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<?> deleteRestaurantDetails(@PathVariable 
			Long restaurantId)
	{
		System.out.println("in delete "+restaurantId);
	
			//invoke servlice layer's method
			return ResponseEntity
					.ok(restaurantService.deleteDetails(restaurantId));

	}
	/*
	 * Desc - Get restaurant details by id 
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - GET
	 * Payload - none
	 * Success Resp -SC  200 + Restaurant (Entity)
	 *  Error resp - SC 404 ,ApiReponse with error mesg
	 */
	@GetMapping("/{restaurantId}")
	//swagger annotation
	@Operation(description = "Get restaurant details by id")
	public ResponseEntity<?> getRestaurantDetails(
			@PathVariable @NotNull @Min(1) @Max(100)  Long restaurantId)
	{
		System.out.println("in get "+restaurantId);

			return ResponseEntity.ok(
						restaurantService.getRestaurantDetails(restaurantId));

	}
	
	/*
	 * Desc - Update restaurant details by id 
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - PUT
	 * Payload -Updated  Restaurant entity 
	 * Success Resp -SC  200 + Restaurant (Entity)
	 *  Error resp - SC 404 ,ApiReponse with error mesg
	 */
	@PutMapping("/{restaurantId}")
	public ResponseEntity<?> updateDetails(@PathVariable 
			Long restaurantId, @RequestBody AddRestaurantDTO dto) {
		System.out.println("in update "+restaurantId+" dto");

			return ResponseEntity.ok(
					restaurantService.updateRestaurant(restaurantId, dto));

		
	}
	
	/*
	 * Desc - Get selected  restaurant n its menu 
	 * URL - http://host:port/restaurants/{restaurantId}/menu
	 * Method - GET 
	 * Payload - none 
	 * Successful Resp -SC 200 , body - restaurant n its menu (dto)
	 * invalid restaurant id  - SC 404 ,Apiresp - error mesg
	 */
	@GetMapping("/{restaurantId}/menu")
	@Operation(description = "Get selected  restaurant n its menu")
	public ResponseEntity<?> getRestaurantAndMenu(@PathVariable Long restaurantId)
	{
		System.out.println("in get complete details "+restaurantId);
		return ResponseEntity
				.ok(restaurantService.getCompleteDetails(restaurantId));
	}
	
	
}
