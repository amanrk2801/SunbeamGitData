package com.sunbeam.service;

import com.sunbeam.dto.SignInDTO;
import com.sunbeam.dto.SignupReqDTO;
import com.sunbeam.dto.UserDTO;

public interface UserService {
//sign in
	UserDTO signIn(SignInDTO dto);

	UserDTO signUp(SignupReqDTO dto);
}
