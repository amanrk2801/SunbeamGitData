package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sunbeam.entities.Restaurant;

@Repository // mandatory cls level annotation to declare spring bean containing data access
			// logic
public class RestaurantDaoImpl implements RestaurantDao {
	//depcy
	@Autowired //SC matches it by data type , using field level D.I
	private SessionFactory factory;

	@Override
	public List<Restaurant> getAvailableRestaurants() {
		String jpql="select r from Restaurant r where r.status=true";
		return factory.getCurrentSession()
				.createQuery(jpql, Restaurant.class)
				.getResultList();
	}

}
