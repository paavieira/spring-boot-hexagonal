package com.paavieira.quickstarts.customer.framework;

import java.util.List;
import java.util.stream.Collectors;

import com.paavieira.quickstarts.customer.application.FindAllCustomersCommandHandler;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.domain.FindAllCustomersCommand;

import org.springframework.stereotype.Service;

@Service
public class FindAllCustomersService {

	private FindAllCustomersCommandHandler handler;
	private CustomerEntityConverter converter;

	public FindAllCustomersService(
		CustomerRepository repository,
		CustomerEntityConverter converter
	) {
		this.handler = new FindAllCustomersCommandHandler(repository); // TODO: how to inject the handler without any framework dependencies?
		this.converter = converter;
	}

	public List<CustomerEntity> findAll() {
		final FindAllCustomersCommand command = new FindAllCustomersCommand();
		final List<Customer> customers = this.handler.handle(command);
		return customers.stream().map(customer -> this.converter.convert(customer)).collect(Collectors.toList());
	}


}
