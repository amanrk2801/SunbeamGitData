package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodItemDTO {
	private String itemName;
	private String itemDescription;	
	private boolean isVeg;
	private int price;
}
