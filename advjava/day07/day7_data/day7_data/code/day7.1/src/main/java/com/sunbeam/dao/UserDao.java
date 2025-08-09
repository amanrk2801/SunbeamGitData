package com.sunbeam.dao;

import com.sunbeam.entities.User;

public interface UserDao {
//add a method - to register new user - insert
	String registerUser(User user);
}
