package com.paavieira.quickstarts.customer.application;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import com.paavieira.quickstarts.architecture.domain.CommandHandler;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.domain.FindCustomerCommand;
import com.paavieira.quickstarts.customer.framework.CustomerRepository;

public class FindCustomerCommandHandler implements CommandHandler<FindCustomerCommand, Customer> {

	private CustomerRepository repository;

	public FindCustomerCommandHandler(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Customer> handle(FindCustomerCommand command) {
		return Arrays.asList(repository.find(command.getId()).get());
	}

}