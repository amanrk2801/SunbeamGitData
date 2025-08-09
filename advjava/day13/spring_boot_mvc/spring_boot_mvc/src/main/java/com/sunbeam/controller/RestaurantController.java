package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
 //depcy  - service layer interface
	@Autowired 
	private RestaurantService restaurantService;
	public RestaurantController() {
		System.out.println("in ctor of "+getClass());
	}
	/*
	 * Desc - add new method for rendering list of restaurants
	 * URL - http://host:port/ctx/restaurants/list
	 * Method - GET
	 * Payload - none
	 * Resp - render dyn resp (list)
	 */
	@GetMapping("/list")
	public String listRestaurants(Model modelAttrMap) {
		System.out.println("in list "+modelAttrMap);//{}
		//add list of restaurant(from service layer) in model map
		modelAttrMap.addAttribute
		("restaurant_list", restaurantService.getAvailableRestaurants());
		//ret LVN 
		return "restaurants/list";
		//AVN - /WEB-INF/views/restaurants/list.jsp
	}
	
	
	
}
