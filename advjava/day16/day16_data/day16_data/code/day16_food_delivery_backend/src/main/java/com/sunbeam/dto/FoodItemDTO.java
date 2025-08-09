package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemDTO {
	private String itemName;
	private String itemDescription;	
	private boolean isVeg;
	private int price;
}
