package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true,exclude = "products")
@Getter
@Setter
public class Category extends BaseEntity {
	@Column(length = 50, unique = true)
	private String name;
	private String description;
	@OneToMany(mappedBy = "productCategory", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();
}
