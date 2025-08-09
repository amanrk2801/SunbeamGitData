package com.sunbeam.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity //mandatory class level annotation to declare entity class
@Table(name="users") //class level annotation , to specify table name
public class User {
	@Id //mandatory field level , PK constraint
	//for auto id generation with auto_increment (for Mysql db)
	@GeneratedValue //=> GenerationType.AUTO => hibernate creates
	//a table (hibernate_sequence , gets ids from it)
	(strategy = GenerationType.IDENTITY) //auto_increment (for Mysql db)
	private Long id;
	@Column(name="first_name",length = 30) //to specify col name 
	//n varchar size
	private String firstName;
	@Column(name="last_name",length = 35)
	private String lastName;
	@Column(length = 30,unique = true)//adds unique constraint
	private String email;	
	@Column(length = 300,nullable = false) //not null constraint
	private String password;
	@Transient //to skip the column generation
	private String confirmPassword;
	@Column(name="subscription_amount")
	private double subscriptionAmount;
	@Enumerated(EnumType.STRING) //to specfy col type - enum
	@Column(name="user_role")
	private UserRole userRole;
	@Lob //to specify col type - blob(longblob)
	private byte[] image;
	/*no extra annotation required for LocalDate | LocalTime | LocalDateTime
	 * for java.util - Date , Calendar  - 
	 *  @Temporal - required additionally
	 */	
	private LocalDate dob;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String firstName, String lastName, String email, String password, double subscriptionAmount,
			UserRole userRole,LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.subscriptionAmount = subscriptionAmount;
		this.userRole = userRole;
		this.dob=dob;
	}
	
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	//getters n setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public double getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public void setSubscriptionAmount(double subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", subscriptionAmount=" + subscriptionAmount 
				+ ", userRole=" + userRole + " Dob"+dob;
	}
	
	

}
