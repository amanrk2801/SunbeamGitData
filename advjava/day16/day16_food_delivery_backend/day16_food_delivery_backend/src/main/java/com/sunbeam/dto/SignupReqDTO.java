package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entities.UserRole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class SignupReqDTO{
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	
	private double subscriptionAmount;
	
	private UserRole userRole;
	
	private LocalDate dob;

}
