package com.paavieira.quickstarts.customer.framework;

import java.util.List;
import java.util.stream.Collectors;

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
		return this.convert(entity);
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll().stream().map(entity -> this.convert(entity)).collect(Collectors.toList());
	}

	private Customer convert(CustomerEntity entity) {
		return Customer.create(entity.getId(), entity.getFirstName(), entity.getLastName());
	}

}