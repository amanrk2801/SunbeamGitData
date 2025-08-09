package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.InvalidInputException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RestaurantDTO;
import com.sunbeam.dto.RestaurantMenuDTO;
import com.sunbeam.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service // class level annotation to declare spring bean - B.L
@Transactional // for auto tx management - import from o.s
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
	// depcy - dao layer interface
	private final RestaurantDao restaurantDao;
	private final ModelMapper modelMapper;

	@Override
	public List<RestaurantDTO> getAvailableRestaurants() {
		// get List<Entity> from DAO ---> convert it --> List<DTO>
		return restaurantDao.findByStatusTrue() // List<Entity>
				.stream() // Stream<Entity>
				.map(entity -> modelMapper.map(entity, RestaurantDTO.class)) // Stream<DTO>
				.toList();
	}

	@Override
	public ApiResponse deleteDetails(Long id) {
		// 1. get restaurant by its id
		Restaurant restaurant = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found - invalid ID!!!!"));
		// => restaurant : PERSISTENT
		// set status : false
		restaurant.setStatus(false);
		return new ApiResponse("Soft Deleted restuarant details");
	}
	/*
	 * When method rets (transactional) - checks for run time exc - exc -> tx mgr
	 * will auto rollback tx - session.close() -> rets DB cn to DBCP (Hikari DBCP)
	 * L1 cache is destroyed.
	 * 
	 * - no exc -> tx mgr will auto commit tx - session.flush -> dirty checking ->
	 * DML : update - session.close() -> rets DB cn to DBCP (Hikari DBCP) L1 cache
	 * is destroyed.
	 */

	@Override
	public ApiResponse addNewRestaurant(AddRestaurantDTO dto) {
		// 1. validate if restaurant name exists
		if (restaurantDao.existsByName(dto.getName()))
			throw new InvalidInputException("Dup restaurant name!!!!!!!!!!");
		// 2 Convert dto -> entity
		Restaurant entity = modelMapper.map(dto, Restaurant.class);
		// set status - true
		entity.setStatus(true);
		// invoke dao's - inherited API
		Restaurant persistentEntity = restaurantDao.save(entity);
		return new ApiResponse("Added new restaurant with ID " + persistentEntity.getId());
	}

	@Override
	public RestaurantDTO getRestaurantDetails(Long id) {
		// invoke dao's method - findById
		Restaurant entity = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant ID!!!!"));
		// map entity -> dto
		/*
		 * API of ModelMapper public <D> D map(Object src, Class<D> destinationClass);
		 * 1. create dest class instance - using def constructor 2. calls getter on src
		 * -> calls MATCHING setter on dest obj *
		 */
		return modelMapper.map(entity, RestaurantDTO.class);
	}

	@Override
	public ApiResponse updateRestaurant(Long id, AddRestaurantDTO dto) {
		// 1. validate if restaurant name exists
		if (restaurantDao.existsByName(dto.getName()))
			throw new InvalidInputException("Dup restaurant name!!!!!!!!!!");
		// 2. => no dup name , validate restaurant id
		Restaurant entity = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant ID!!!!"));
//		call setters : NOT REQUIRED!!!!!!!!!!!
//		restaurant2.setAddress(restaurant.getAddress());
//		restaurant2.setName(restaurant.getName());
//		restaurant2.setCity(restaurant.getCity());
//		restaurant2.setDescription(restaurant.getDescription());
		// => valid restaurant id
		// restaurantDao.save(restaurant);
		// 3.  entity : persistent , map dto -> entity (null values will not be transferred
		//- thanks to model mapper configuration
		modelMapper.map(dto, entity);
		return new ApiResponse("Updated restaurant details ....");
	}// in case of success -> tx.commit -> dirty checking -> DML - udate ....

	@Override
	public RestaurantMenuDTO getCompleteDetails(Long restaurantId) {
		// 1. call dao's method to get restaurant n menu
		Restaurant entity = restaurantDao.getRestaurantAndMenu(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found - invalid id !!!!"));
		// 2. entity -> dto
		return modelMapper.map(entity, RestaurantMenuDTO.class);
	}

}
