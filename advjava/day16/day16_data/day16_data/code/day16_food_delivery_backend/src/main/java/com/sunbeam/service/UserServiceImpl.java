package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationFailureException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.SignInDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entities.User;

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
		User entity=
		userDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
		.orElseThrow(() -> new AuthenticationFailureException("Invalid email or password"));
		//2. successful login , map entity -> dto
		return modelMapper.map(entity, UserDTO.class);
	}

}
