package com.paavieira.quickstarts.customer.domain;

import com.paavieira.quickstarts.architecture.domain.Model;

import org.springframework.util.StringUtils;

public class Customer implements Model {

	private final String id;
	private final String firstName;
	private final String lastName;
	private final String email;

	private Customer(final String id, final String firstName, final String lastName, final String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public static Customer create(final String firstName, final String lastName, final String email) {
		return Customer.create(null, firstName, lastName, email);
	}

	public static Customer create(final String id, final String firstName, final String lastName, final String email) {

		final boolean isFirstNameEmpty = StringUtils.isEmpty(firstName);
		final boolean isLastNameEmpty = StringUtils.isEmpty(lastName);

		if (isFirstNameEmpty || isLastNameEmpty) {
			throw new InvalidCustomerName(firstName, lastName);
		}

		final boolean isEmailEmpty = StringUtils.isEmpty(email);
		if (isEmailEmpty) {
			throw new InvalidCustomerEmail(email);
		}

		return new Customer(id, firstName, lastName, email);

	}

	public String getId() {
		return id;
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