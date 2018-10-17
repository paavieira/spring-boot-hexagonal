package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.architecture.domain.Repository;
import com.paavieira.quickstarts.customer.domain.Customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerRepository implements Repository<Customer> {

	private CustomerEntityRepository repository;

	public CustomerRepository(CustomerEntityRepository repository) {
		this.repository = repository;
	}

	@Override
	public Customer save(Customer customer) {
		final CustomerEntity entity = repository.save(new CustomerEntity(customer.getFirstName(), customer.getLastName()));
		return Customer.create(entity.getId(), entity.getFirstName(), entity.getLastName());
	}

}