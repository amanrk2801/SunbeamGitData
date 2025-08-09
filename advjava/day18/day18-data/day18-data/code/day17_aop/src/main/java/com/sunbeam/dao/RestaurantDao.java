package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant,Long>{
//list all available restaurants - derived query method
	List<Restaurant> findByStatusTrue();
	//add derived query method 
	boolean existsByName(String restaurantName);
	//custom query - join fetch
	@Query("select r from Restaurant r left join fetch r.foodItems where r.id=:id")
	Optional<Restaurant> getRestaurantAndMenu(Long id);
}
