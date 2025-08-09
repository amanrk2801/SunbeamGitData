package com.sunbeam.dao;

import com.sunbeam.entities.User;
//import the static method of HibernateUtils
import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.*;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
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
			// 4. end of try block => success -> commit transaction
			tx.commit();
			message = "User registered successfully , "
					+ "with generated ID " + user.getId();
		} catch (RuntimeException e) {
			//4.  => failure -> rollback tx
			if (tx != null)
				tx.rollback();
			//5.  re throw the same exception to the caller (to inform)
			throw e;
		}
		return message;
	}

}
