package com.paavieira.quickstarts.customer.application;

import java.util.List;

import com.paavieira.quickstarts.architecture.domain.CommandHandler;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.domain.FindAllCustomersCommand;
import com.paavieira.quickstarts.customer.framework.CustomerRepository;

public class FindAllCustomersCommandHandler implements CommandHandler<FindAllCustomersCommand, Customer> {

	private CustomerRepository repository;

	public FindAllCustomersCommandHandler(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Customer> handle(FindAllCustomersCommand command) {
		return this.repository.findAll();
	}

}