package com.sunbeam.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * To declare a common base dto class 
 */

@Getter
@Setter
@ToString
public class BaseDTO {
	// add common fields	
	private Long id;	
	private LocalDate creationDate;	
	private LocalDateTime updatedOn;
}
