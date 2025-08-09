package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@EqualsAndHashCode(of = "name", callSuper = false)
public class Restaurant extends BaseEntity {
	@Column(length = 100, unique = true)
	private String name = "some name";
	private String address;
	@Column(length = 20)
	private String city;
	private String description;
	// Restaurant 1<----->* FoodItem
	//@JsonIgnore// annotation meant for Jackson 
	//- to skip a field during serial n de-serial
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
		this.status = true;
	}
	//add helper methods - add food item n remove food item
	public void addFooditem(FoodItem foodItem)
	{
		this.foodItems.add(foodItem);
		foodItem.setMyRestaurant(this);
	}
	public void removeFooditem(FoodItem foodItem)
	{
		this.foodItems.remove(foodItem);
		foodItem.setMyRestaurant(null);
	}

}
