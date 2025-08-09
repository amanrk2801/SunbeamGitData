package com.sunbeam.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunbeam.dto.RestaurantRespDTO;

@FeignClient("Restaurant-Service")
public interface RestaurantClient {
	@GetMapping("/restaurants/{restaurantId}")
	RestaurantRespDTO getRestaurantDetails(@PathVariable Long restaurantId);

}
