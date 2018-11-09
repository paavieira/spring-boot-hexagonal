package com.paavieira.quickstarts.customer.domain;

public class InvalidCustomerEmail extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String email;

	public InvalidCustomerEmail(final String email) {
		this.email = email;
	}

	@Override
	public String getMessage() {
		return String.format("Invalid customer email: %s", this.email);
	}

}