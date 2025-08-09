package com.sunbeam.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * product id : Long (auto increment)
name : string (unique) : varchar(20)
product description : string : varchar(300)
manufacture date : LocalDate
price : double
available quantity : int

 */
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true,exclude = "productCategory")
@Getter
@Setter
public class Product extends BaseEntity {
	@Column(length = 20,unique = true)
	private String name;
	@Column(length = 300)
	private String description;
	@Column(name="manufacture_date")
	private LocalDate manufactureDate;
	private double price;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private Category productCategory;
}
