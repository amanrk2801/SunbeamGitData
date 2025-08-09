package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

public interface UserDao extends JpaRepository<User,Long> {
//sign in 
	Optional<User> findByEmailAndPassword(String em,String pwd);
	//list top 3 users by specified user role  , sorted by sub amount in desc order
	//sql - select * from users where user_role=? order by subscription_amount limit 3 
	List<User> findTop3ByUserRoleOrderBySubscriptionAmountDesc(UserRole role);
	//exists by email
	boolean existsByEmail(String email);
}
