package com.sunbeam.value_types;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable // user defined type - whose contents will be embedded in 
//owning entity.
public class AdhaarCard {
	@Column(name="card_number",length = 20,unique = true)
	private String cardNumber;
	@Column(name="created_on")
	private LocalDate createdOn;
	@Column(length = 30)
	private String location;
}
