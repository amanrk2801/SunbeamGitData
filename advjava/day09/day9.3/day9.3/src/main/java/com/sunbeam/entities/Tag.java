package com.sunbeam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	

	public Tag(String name) {
		super();
		this.name = name;
	}

}
