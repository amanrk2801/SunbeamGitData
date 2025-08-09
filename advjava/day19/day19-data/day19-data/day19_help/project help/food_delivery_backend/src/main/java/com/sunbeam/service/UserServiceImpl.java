package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UserRequestDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.UserEntity;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	// depcy
	private final UserDao userDao;
	private ModelMapper mapper;
	private PasswordEncoder passwordEncoder;

	

	@Override
	public UserRespDTO signUp(UserRequestDTO dto) {
		// 1. check for dup email
		if (userDao.existsByEmail(dto.getEmail()))
			throw new ApiException("Dup Email detected - User exists already!!!!");
		// 2. dto -> entity

		UserEntity entity = mapper.map(dto, UserEntity.class);
		//3. encrypt password
		entity.setPassword(passwordEncoder.
				encode(entity.getPassword()));
		//4. save the entity n map persistent entity -> resp dto
		return mapper.map(userDao.save(entity), UserRespDTO.class);
	}

	@Override
	public ApiResponse assignAddress(Long userId, AddressDTO dto) {
		//1. get user by its id
		UserEntity userEntity=userDao.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("Invalid user id - can;t link user address!!!!!"));
		//userEntity : persistent
		//2. map adr dto -> adr entity
		Address adrEntity=mapper.map(dto, Address.class);
		//3 establish uni dir asso between entities : User 1--->1 Address
		userEntity.setMyAddress(adrEntity);//modifying state of persistent entity
		return new ApiResponse("address linked to user ....");
	}//no run time exc -> tx.commit -> session.flush ->  DML -> insert - adr , update - users -> close

	@Override
	public List<UserRespDTO> getAllUsersByCity(String city) {
		// invoke dao's method
		return userDao.findByMyAddressCity(city) //List<Entity>
		.stream() //Stream<E>
		.map(user -> mapper.map(user, UserRespDTO.class))
		.toList();
		
	}
	
	

}
