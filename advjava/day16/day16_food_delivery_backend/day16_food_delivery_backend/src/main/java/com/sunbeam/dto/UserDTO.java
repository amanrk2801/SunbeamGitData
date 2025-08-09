package com.sunbeam.dto;

import com.sunbeam.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO{
	
	private String firstName;
	private String lastName;	
	private String email;		
	private double subscriptionAmount;	
	private UserRole userRole;
}
