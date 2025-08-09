package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.InvalidInputException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Restaurant;

@Service//class level annotation to declare spring bean - B.L
@Transactional //for auto tx management - import from o.s
public class RestaurantServiceImpl implements RestaurantService {
	//depcy - dao layer interface
	@Autowired //by type
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getAvailableRestaurants() {
		// TODO Auto-generated method stub
		return restaurantDao.findByStatusTrue();
	}

	@Override
	public ApiResponse deleteDetails(Long id) {
		// 1. get restaurant by its id
		Restaurant restaurant=restaurantDao.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException
				("Restaurant not found - invalid ID!!!!"));
		//=> restaurant : PERSISTENT
		//set status : false
		restaurant.setStatus(false);
		return new ApiResponse("Soft Deleted restuarant details");
	}
	/*
	 * When method rets (transactional)
	 *  - checks for run time exc 
	 *  - exc -> tx mgr will auto rollback tx
	 *    - session.close() -> rets DB cn to DBCP (Hikari DBCP)
	 *     L1 cache is destroyed.
	 *     
	 *   - no exc ->   tx mgr will auto commit tx
	 *    - session.flush -> dirty checking -> DML : update
	 *    - session.close() -> rets DB cn to DBCP (Hikari DBCP)
	 *     L1 cache is destroyed.
	 */

	@Override
	public ApiResponse addNewRestaurant(Restaurant transientRestaurant) {
		//validate if restaurant name exists
		if(restaurantDao.existsByName(transientRestaurant.getName()))
			throw new InvalidInputException("Dup restaurant name!!!!!!!!!!");
		//set status - true
		transientRestaurant.setStatus(true);
		//invoke dao's - inherited API
		Restaurant persistentEntity = restaurantDao.save
				(transientRestaurant);
		return new ApiResponse(
				"Added new restaurant with ID "
				+persistentEntity.getId());
	}

	@Override
	public Restaurant getRestaurantDetails(Long id) {
		// invoke dao's method - findById
		return restaurantDao.findById(id) 
				.orElseThrow(() -> 
				new ResourceNotFoundException
				("Invalid restaurant ID!!!!"));
	}

	@Override
	public ApiResponse updateRestaurant(Long id, Restaurant restaurant) {
		Restaurant restaurant2=getRestaurantDetails(id);
		//call setters
		restaurant2.setAddress(restaurant.getAddress());
		restaurant2.setName(restaurant.getName());
		restaurant2.setCity(restaurant.getCity());
		restaurant2.setDescription(restaurant.getDescription());
		//=> valid restaurant id
	//	restaurantDao.save(restaurant);
		return new ApiResponse(
				"Updated restaurant details ....");
	}//in case of success -> tx.commit -> dirty checking -> DML - udate ....
	
	
	
	
	
	
	
	

}
