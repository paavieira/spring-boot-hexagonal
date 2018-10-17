package com.paavieira.quickstarts.customer.domain;

public class InvalidCustomerName extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String firstName;
	private final String lastName;

	public InvalidCustomerName(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String getMessage() {
		return String.format("Invalid customer name: %s %s", this.firstName, this.lastName);
	}

}