package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.customer.domain.Customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerEntityConverter {

	public CustomerEntity convert(Customer customer) {
		return new CustomerEntity(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
	}

}