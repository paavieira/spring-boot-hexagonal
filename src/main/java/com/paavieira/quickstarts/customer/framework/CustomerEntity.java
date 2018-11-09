package com.paavieira.quickstarts.customer.framework;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@ValidFullName
public class CustomerEntity {

	@Id
	private String id;

	@Size(min = 3, message = "First name is too short")
	private String firstName;

	@Size(min = 3, message = "Last name is too short")
	private String lastName;

	@Indexed(unique = true)
	@NotEmpty(message = "Email is required")
	@Email(message = "Email is invalid")
	private String email;

	public CustomerEntity() {}

	public CustomerEntity(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public CustomerEntity(String firstName, String lastName, String email) {
		this(null, firstName, lastName, email);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}