package com.paavieira.quickstarts.customer.framework;

import org.springframework.data.annotation.Id;

public class CustomerEntity {

	@Id
	private String id;

	private String firstName;
	private String lastName;

	public CustomerEntity() {}

	public CustomerEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

}