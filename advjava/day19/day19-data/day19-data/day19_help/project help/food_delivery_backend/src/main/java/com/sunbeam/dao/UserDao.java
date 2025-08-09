package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

	// derived method
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
	//derived finder
	boolean existsByEmail(String email);
	//derived finder
	List<UserEntity> findByMyAddressCity(String city);
	//derived finder
	Optional<UserEntity> findByEmail(String email);
}
