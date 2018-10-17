package com.paavieira.quickstarts.customer.application;

import java.util.Arrays;
import java.util.List;

import com.paavieira.quickstarts.architecture.domain.CommandHandler;
import com.paavieira.quickstarts.customer.domain.CreateCustomerCommand;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.framework.CustomerRepository;

public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, Customer> {

	private CustomerRepository repository;

	public CreateCustomerCommandHandler(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Customer> handle(CreateCustomerCommand command) {
		final Customer created = Customer.create(command.getFirstName(), command.getLastName());
		final Customer saved = this.repository.save(created);
		return Arrays.asList(saved);
	}

}