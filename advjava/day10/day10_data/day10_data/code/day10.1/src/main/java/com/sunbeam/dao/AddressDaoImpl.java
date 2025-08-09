package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignUserAddress(Long userId, Address adr) {
		String mesg = "address linking failed !!!!!";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get user from its id
			User user = session.get(User.class, userId);
			// 4. null checking - not null
			if (user != null) {
				// user : persistent -> set user address
				user.setUserAddress(adr);// modifying state of persistent entity
				//user ---> address
				// no need of session.persist(adr) - 
				//since used cascadeType.ALL - save, update n delete 
				mesg="assigned user address";
			}
			tx.commit();//perform dirty checking -> insert in adr 
			//n update in users table to link FK
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw exc to the caller
			throw e;
		}

		return mesg;
	}

}
