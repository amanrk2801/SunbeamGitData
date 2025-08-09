package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.entities.Restaurant;
import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestUserDao {
	@Autowired
	private UserDao userDao;
	
	@Test
	void testFindTop3ByUserRoleOrderBySubscriptionAmountDesc() {
		List<User> list = userDao.
		findTop3ByUserRoleOrderBySubscriptionAmountDesc(UserRole.CUSTOMER);
		list.forEach(System.out::println);
		assertEquals("Meera", list.get(0).getFirstName());
	}
	@Test
	void testFetchUserLastNamesByCity() {
		List<String> lastNames = userDao.fetchUserLastNamesByCity("Pune");
		lastNames.forEach(System.out::println);
		assertEquals(4, lastNames.size());
	}

	

}
