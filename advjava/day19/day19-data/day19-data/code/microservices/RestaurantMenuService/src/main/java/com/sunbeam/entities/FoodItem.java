package com.sunbeam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//to add composite unique constraint on multiple columns 
@Table(name = "food_items",
uniqueConstraints = @UniqueConstraint
(columnNames = {"item_name","restaurant_id"}))
@NoArgsConstructor

@ToString(callSuper = true)
@Getter
@Setter
public class FoodItem extends BaseEntity {
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_description",length = 100)
	private String itemDescription;
	@Column(name="is_veg")
	private boolean isVeg;
	private int price;
	private Long restaurantId;
		public FoodItem(String itemName, String itemDescription, boolean isVeg, int price) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.isVeg = isVeg;
		this.price = price;
	}
	

}
