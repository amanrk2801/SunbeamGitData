package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

public interface UserDao {
//add a method to sign up new user
	String signUp(User user);

	User getUserDetails(Long userId);

	List<User> getAllUsers();

	List<User> getSelectedUsers(LocalDate start,
			LocalDate end,UserRole role);

	User userSignIn(String next, String next2);

	List<String> getSelectedUsersFirstNames(UserRole valueOf);

	List<User> getSelectedUsersDetails(UserRole valueOf);

	String updateUserDetails(LocalDate date, double discount);

	User getUserAndAddress(String userEmail);
}
