package com.sunbeam.dao;

import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

//import the static method of HibernateUtils
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
		// user - TRANSIENT (exists only in heap)
		String message = "User reg failed!!!!!!";
		// 1. Get Hibernate Session from SessionFactory
		/*
		 * API of SessionFactory public Session getCurrentSession() throws
		 * HibernateException OR public Session openSession() throws HibernateException
		 */
		Session session = getFactory().getCurrentSession();
		/*
		 * 2. Begin a Transaction API of Session public Transaction beginTransaction()
		 * throws HibernateException
		 */
		Transaction tx = session.beginTransaction();
		try {
			// 3. CRUD API- persist
			/*
			 * API of Session for insertion public void persist(Object ref) throws
			 * HibernateException arg - transient entity (not yet persistent)
			 * 
			 */
			session.persist(user);
			// user - PERSISTENT (part of L1 cache)
			// 4. end of try block => success -> commit transaction
			tx.commit();// DML - insert
			/*
			 * What happens upon commit ? 1. session.flush() Hibernate Performs auto dirty
			 * checking -> compares state of L1 cache with that of DB -> new entity - insert
			 * -> updated state of entity - update -> entity marked for removal - delete 2.
			 * session.close() -> L1 cache is destroyed -> DB connection rets to the DBCP
			 * (so that same DB cn can be reused for any other request) -> increases
			 * scalability.
			 */
			message = "User registered successfully , " + "with generated ID " + user.getId();
		} catch (RuntimeException e) {
			// 4. => failure -> rollback tx
			if (tx != null)
				tx.rollback();
			/*
			 * What happens upon rollback ? 1. session.close() -> L1 cache is detsroyed ->
			 * DB cn rets to DBCP
			 */
			// 5. re throw the same exception to the caller (to inform)
			throw e;
		}
		// user - DETACHED
		return message;
	}

	public User getUserDetailsById(Long userId) {
		User user = null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userId);
			/*
			 * Hibernate checks first in L1 cache , for the entity - exists - rets the
			 * entity from L1 cache. - does not exist - fires select query -> ResultSet ->
			 * ORM -> persistent entity
			 */
//			user=session.get(User.class, userId);
//			user=session.get(User.class, userId);
//			user=session.get(User.class, userId);
			// user in case of valid id
			// - PERSISTENT(exists in L1 cache n DB)
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		// user - DETACHED from L1 cache
		return user;
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			// users - list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return users;// users - list of detached entities
	}

	@Override
	public List<User> getUserDetailsByRoleAndDate(UserRole role1, LocalDate date1) {
		List<User> users = null;
		String jpql = "select u from User u where u.userRole=:role and u.dob>:date";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class)
					// set named IN params
					.setParameter("role", role1).setParameter("date", date1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getUserLastNamesByRole(UserRole userRole) {
		List<String> lastNames = null;
		String jpql = "select u.lastName from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return lastNames;
	}

	@Override
	public List<User> getCompleteNameAndDobByRole(UserRole userRole) {
		List<User> users = null;
		String jpql = "select new " + "com.sunbeam.entities.User(u.firstName,u.lastName,u.dob)"
				+ "  from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email1, String oldPassword, String newPassword) {
		User user = null;
		String mesg = "Password updation failed!!!!!!";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email1).setParameter("pass", oldPassword)
					.getSingleResult();
			// => success -> user : PERSISTENT
			user.setPassword(newPassword);// modifying state of the persistent entity
			// session.evict(user);//user - DETACHED
			tx.commit();
			mesg = "Password updated !";
			/*
			 * session.flush() -> auto dirty checking -> updated entity state -> DML -
			 * update session.close()
			 * 
			 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		// user - DETACHED
		user.setPassword("1234567890");
		return mesg;
	}

	@Override
	public String applyDiscount(UserRole userRole, LocalDate dob, double discount) {
		String mesg = "applying discount failed !!!!!!!!!!";
		String jpql = "update User u set " + "u.subscriptionAmount=u.subscriptionAmount-:disc "
				+ "where u.userRole=:rl and u.dob < :date";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createMutationQuery(jpql).setParameter("disc", discount)
					.setParameter("rl", userRole).setParameter("date", dob).executeUpdate();
			tx.commit();
			mesg = "applied discount to " + updateCount + " no users";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return mesg;
	}

	public String deleteUserDetailsById(Long userId) {
		User user=null;
		String mesg = "deletion failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get user details by id
			user=session.get(User.class, userId);
			if (user != null)
			{
				//=> valid user id , user : PERSISTENT
				session.remove(user);//user - REMOVED(marked for removal)
				mesg="user details deleted....";
			}
			tx.commit();
			/*
			 * session.flush() -> auto dirty checking -> DML - delete 
			 * session.close() -> L1 cache is destroyed and db cn rets to DBCP
			 */
			//user : transient
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return mesg;
	}//user - marked for GC -> does not exist !!!!!

}
