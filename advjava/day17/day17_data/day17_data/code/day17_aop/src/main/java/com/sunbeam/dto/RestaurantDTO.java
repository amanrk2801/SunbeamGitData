package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDTO extends BaseDTO{
	private String name ;
	private String address;	
	private String city;
	private String description;

}
