package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.UserEntity;
import com.sunbeam.entities.UserRole;

public interface UserDao extends JpaRepository<UserEntity,Long> {
//sign in 
	Optional<UserEntity> findByEmailAndPassword(String em,String pwd);
	//list top 3 users by specified user role  , sorted by sub amount in desc order
	//sql - select * from users where user_role=? order by subscription_amount limit 3 
	List<UserEntity> 
	findTop3ByUserRoleOrderBySubscriptionAmountDesc(UserRole role);
	//exists by email
	boolean existsByEmail(String email);
	//get all user by city
	List<UserEntity> findByUserAddressCity(String cityName);
	//get all users' lastnames by city - custom query
	@Query("select u.lastName from UserEntity u where u.userAddress.city=:city1")
	List<String> fetchUserLastNamesByCity(@Param("city1")  String city);
	//get all users' firstname , lastname n  role by city - custom query +JPQL constr expression
	//with custom DTO - Try it out !!!!!
}
