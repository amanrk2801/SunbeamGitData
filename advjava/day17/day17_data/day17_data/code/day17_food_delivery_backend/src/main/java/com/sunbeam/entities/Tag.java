package com.sunbeam.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;	
	//Tag *---->* Restaurant
	@ManyToMany //mandatory - other hibernate throws exception
	//to customize link table 
	@JoinTable(name = "my_restaurants_tags")
	private Set<Restaurant> restaurants=new HashSet<>();

	public Tag(String name) {
		super();
		this.name = name;
	}

}
