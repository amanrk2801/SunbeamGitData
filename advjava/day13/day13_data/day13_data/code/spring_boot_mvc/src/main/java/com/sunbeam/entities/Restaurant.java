package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "foodItems")
@EqualsAndHashCode(of="name",callSuper = false)
public class Restaurant extends BaseEntity {
	@Column(length = 100, unique = true)
	private String name;
	private String address;
	@Column(length = 20)
	private String city;
	private String description;
	// Restaurant 1----> * FoodItem
	@OneToMany(mappedBy = "myRestaurant",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FoodItem> foodItems = new ArrayList<>();
	private boolean status;

	public Restaurant(String name, String address, String city, String description) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
		this.status=true;
	}

	// add helper method - add food item
	public void addFoodItem(FoodItem item) {
		this.foodItems.add(item);// restaurent -> food item
		item.setMyRestaurant(this);// fooditem -> restaurant
	}
	// add helper method - remove food item
	public void removeFoodItem(FoodItem item) {
		this.foodItems.remove(item);
		item.setMyRestaurant(null);
	}

}
