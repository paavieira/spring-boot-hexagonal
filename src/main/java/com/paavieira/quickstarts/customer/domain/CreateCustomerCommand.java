package com.paavieira.quickstarts.customer.domain;

import com.paavieira.quickstarts.architecture.domain.Command;

public class CreateCustomerCommand implements Command {

	private final String firstName;
	private final String lastName;

	public CreateCustomerCommand(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}