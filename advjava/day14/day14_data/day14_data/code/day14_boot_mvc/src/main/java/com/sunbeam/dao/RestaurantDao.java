package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant,Long>{
//list all available restaurants
	List<Restaurant> findByStatusTrue();
}
