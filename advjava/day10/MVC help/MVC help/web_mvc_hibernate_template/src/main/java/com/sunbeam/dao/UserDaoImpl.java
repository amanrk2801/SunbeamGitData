package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User signIn(String email, String pwd) {
		String jpql="select u from User u where u.email=:em and u.password=:pass";				
		User user=null;
			// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class)
					.setParameter("em",email)
					.setParameter("pass",pwd)
					.getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public String signUp(User newUser) {
		String mesg = "reg failed !!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			// transient -> persistent
			session.persist(newUser);
			tx.commit();
			mesg = "user registered with ID " + newUser.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	

	@Override
	public String updateUserDetails(User user) {
		String mesg = "Updation failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			//detached -> persistent
			session.merge(user);
			tx.commit();//auto dirty checking -> update query
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUser(Long userId) {
		String mesg = "Deletion failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			
			User user=session.get(User.class, userId);
			if(user != null)
			{
				//user persistent -> soft delete 
				user.setStatus(false);
			}
			tx.commit();//update 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return mesg;

	}

	@Override
	public List<User> listUsers() {
		List<User> users = null;
		String jpql="select u from User u where u.status=true";				
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users=session.createQuery(jpql, User.class)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return users;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user = null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return user;

	}

}
