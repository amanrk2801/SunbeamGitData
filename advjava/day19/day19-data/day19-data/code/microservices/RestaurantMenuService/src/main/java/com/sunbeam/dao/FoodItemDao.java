package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem, Long> {
	List<FoodItem> findByRestaurantId(Long restaurantId);
	boolean existsByItemNameAndRestaurantId
	(String name,Long restaurantId);
	
}
