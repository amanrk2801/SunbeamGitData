package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Tag;

public class TagDaoImpl implements TagDao {

	@Override
	public String addTag(Tag newTag) {
		String mesg = "adding new tag failed !!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String linkRestaurant(Long tagId, Long restaurantId) {
		String mesg = "Linking tag to restaurant failed !!!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

}
