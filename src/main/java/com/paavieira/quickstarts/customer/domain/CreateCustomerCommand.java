package com.paavieira.quickstarts.customer.domain;

import com.paavieira.quickstarts.architecture.domain.Command;

public class CreateCustomerCommand implements Command {

	private final String firstName;
	private final String lastName;
	private final String email;

	public CreateCustomerCommand(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

}