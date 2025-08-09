package com.sunbeam.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.value_types.AdhaarCard;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // mandatory class level annotation to declare entity class
@Table(name = "users") // class level annotation , to specify table name
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "password", "confirmPassword", "image", "userAddress" })
public class User extends BaseEntity {
	@Column(name = "first_name", length = 30) // to specify col name
	// n varchar size
	private String firstName;
	@Column(name = "last_name", length = 35)
	private String lastName;
	@Column(length = 30, unique = true) // adds unique constraint
	private String email;
	@Column(length = 300, nullable = false) // not null constraint
	private String password;
	@Transient // to skip the column generation
	private String confirmPassword;
	@Column(name = "subscription_amount")
	private double subscriptionAmount;
	@Enumerated(EnumType.STRING) // to specfy col type - enum
	@Column(name = "user_role")
	private UserRole userRole;
	@Lob // to specify col type - blob(longblob)
	private byte[] image;
	/*
	 * no extra annotation required for LocalDate | LocalTime | LocalDateTime for
	 * java.util - Date , Calendar -
	 * 
	 * @Temporal - required additionally
	 */
	private LocalDate dob;
	// User 1--->1 Address
	// if lazy fetching is required in the project 0
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address userAddress;
	// User 1--->1 AdhaarCard (embeddable)
	@Embedded // OPTIONAL
	private AdhaarCard adhaarCard;
	// User 1 ----- List<String: hoobyName>
	@ElementCollection //=> collection of value types
	@CollectionTable(name="my_user_hobbies",
	joinColumns = @JoinColumn(name="user_id"))
	@Column(name="hobby_name")
	private List<String> hobbies = new ArrayList<>();

	public User(String firstName, String lastName, String email, String password, double subscriptionAmount,
			UserRole userRole, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.subscriptionAmount = subscriptionAmount;
		this.userRole = userRole;
		this.dob = dob;
	}

	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

}
