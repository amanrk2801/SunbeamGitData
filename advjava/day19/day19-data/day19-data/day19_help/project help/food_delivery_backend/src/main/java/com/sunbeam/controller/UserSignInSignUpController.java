package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.AuthResp;
import com.sunbeam.dto.UserRequestDTO;
import com.sunbeam.security.JwtUtils;
import com.sunbeam.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserSignInSignUpController {
	//depcy
	private final UserService userService;//still needed for signup
	private AuthenticationManager authenticationManager;
	private JwtUtils jwtUtils;
	/*
	 * User sign in
URL - http://host:port/users/signin
Method - POST
Payload - Auth Request DTO (email ,pwd)
error resp - ApiResp dto - SC 401 , mesg - login failed
success resp - Auth Resp  dto -mesg , JWT
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(
			@RequestBody AuthRequest dto) {
		//1. Create Authentication Token 
		//(UsernamePasswordAuthToken - principal  , crendential)
		UsernamePasswordAuthenticationToken authentication=
				new UsernamePasswordAuthenticationToken
				(dto.getEmail(), dto.getPassword());
		System.out.println("before - "+authentication.isAuthenticated());//false);
		//2.  Invoke authenticate method of AuthenticationManager
		Authentication validAuthentication = 
				authenticationManager.authenticate(authentication);
		System.out.println(validAuthentication.getPrincipal().getClass());
		System.out.println(validAuthentication.getPrincipal());//UserEntity
		System.out.println("after "+validAuthentication.isAuthenticated());//tru
		//3. In case of success , generate JWT n send it to REST client
		return ResponseEntity.ok(
				new AuthResp("auth successful"
						,jwtUtils.generateJwtToken(validAuthentication)));
	}
	/*
	 * User sign up
URL - http://host:port/users/signup
Method - POST
Payload - UserReqDTO (user details)
error resp - ApiResp dto - SC 400 , mesg - reg failed
success resp - UseResp dto - with details
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> userSignUp(@RequestBody @Valid
			UserRequestDTO dto)
	{
		System.out.println("in user signup "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.signUp(dto));
	}
	/*
	 * Assign user address
URL - http://host:port/users/{userId}/address
Method - POST
Payload - address dto
error resp - ApiResp dto - SC 400 , mesg - linking adr failed
success resp - ApiResp dto - success mesg
	 */
	@PostMapping("/{userId}/address")
	public ResponseEntity<?> assignUserAddress(
			@PathVariable Long userId,@RequestBody AddressDTO dto) {
		System.out.println("assign adr ");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.assignAddress(userId,dto));
	}
	

}
