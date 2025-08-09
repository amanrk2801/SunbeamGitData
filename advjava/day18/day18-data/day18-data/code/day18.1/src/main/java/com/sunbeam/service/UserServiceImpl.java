package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationFailureException;
import com.sunbeam.custom_exceptions.InvalidInputException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.SignInDTO;
import com.sunbeam.dto.SignupReqDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entities.UserEntity;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	//depcy - dao layer i/f
	private final UserDao userDao;
	private final ModelMapper modelMapper;
	

	@Override
	public UserDTO signIn(SignInDTO dto) {
		// 1. invoke dao's method
		UserEntity entity=
		userDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
		.orElseThrow(() -> new AuthenticationFailureException("Invalid email or password"));
		//2. successful login , map entity -> dto
		return modelMapper.map(entity, UserDTO.class);
	}


	@Override
	public UserDTO signUp(SignupReqDTO dto) {
		// 1. validate for dup email
		if(userDao.existsByEmail(dto.getEmail()))
			throw new InvalidInputException("User already exists by email !!!!");
		//2. no dup email , map dto -> entity
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		//3. save - inherited api
		UserEntity persistentEntity = userDao.save(entity);
		return modelMapper.map(persistentEntity, UserDTO.class);
	}
	
	

}
