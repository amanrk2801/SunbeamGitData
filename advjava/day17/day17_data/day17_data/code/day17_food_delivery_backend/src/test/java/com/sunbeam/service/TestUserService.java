package com.sunbeam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunbeam.dto.SignInDTO;
import com.sunbeam.dto.UserDTO;
@SpringBootTest
class TestUserService {
	@Autowired
	private UserService userService;

	@Test
	void testSignIn() {
		SignInDTO dto=new SignInDTO("neha.patil@gmail.com", "Neha@123");
		UserDTO resp = userService.signIn(dto);
		System.out.println(resp);
		assertEquals("Neha", resp.getFirstName());
	}

}
