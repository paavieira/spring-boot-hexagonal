package com.paavieira.quickstarts.customer.domain;

import com.paavieira.quickstarts.architecture.domain.Model;

import org.springframework.util.StringUtils;

public class Customer implements Model {

	private final String id;
	private final String firstName;
	private final String lastName;

	private Customer(final String id, final String firstName, final String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static Customer create(final String firstName, final String lastName) {
		return Customer.create(null, firstName, lastName);
	}

	public static Customer create(final String id, final String firstName, final String lastName) {

		final boolean isFirstNameEmpty = StringUtils.isEmpty(firstName);
		final boolean isLastNameEmpty = StringUtils.isEmpty(lastName);

		if (isFirstNameEmpty || isLastNameEmpty) {
			throw new InvalidCustomerName(firstName, lastName);
		}

		return new Customer(id, firstName, lastName);

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

}