package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RestaurantDao;
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
		return restaurantDao.getAvailableRestaurants();
	}

}
