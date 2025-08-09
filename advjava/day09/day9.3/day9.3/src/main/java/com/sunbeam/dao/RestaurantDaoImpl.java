package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

	@Override
	public String addResturant(Restaurant newRestaurant) {
		String mesg = "adding restaurant failed !!!!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newRestaurant);//newRestaurant : persistent
			tx.commit();
			mesg = "added new restaurant , ID" + newRestaurant.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public Restaurant getRestaurantDetails(String restaurantName) {
		Restaurant restaurant = null;
		String jpql="select r from Restaurant r where r.name=:nm";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			restaurant=session.createQuery(jpql, Restaurant.class)
					.setParameter("nm",restaurantName)
					.getSingleResult();
				tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;// in case success - DETACHED or in case of failure - throws NOResultExc
	}

	@Override
	public Restaurant getRestaurantWithMenuDetails(String restaurantName) {
		Restaurant restaurant = null;
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
		
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;
	}

	@Override
	public Restaurant getOrLoadRestaurantDetails(Long restaurantId) {
		Restaurant restaurant = null;
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;
	}

	@Override
	public String deleteResturant(String restaurantName) {
		String mesg="deletion failed !!!!!";
		//1. Get Session from SessionFactory
		Session session=getFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw exc to the caller
			throw e;
		}
	
		return mesg;
	}
	

}
