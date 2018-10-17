package com.paavieira.quickstarts.customer.framework;

import java.util.List;
import java.util.stream.Collectors;

import com.paavieira.quickstarts.customer.application.FindAllCustomersCommandHandler;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.domain.FindAllCustomersCommand;

import org.springframework.stereotype.Service;

@Service
public class FindAllCustomersService {

	private CustomerCommandHandlerResolver handlerResolver;
	private CustomerEntityConverter converter;

	public FindAllCustomersService(
		CustomerCommandHandlerResolver handlerResolver,
		CustomerEntityConverter converter
	) {
		this.handlerResolver = handlerResolver;
		this.converter = converter;
	}

	public List<CustomerEntity> findAll() {
		final FindAllCustomersCommand command = new FindAllCustomersCommand();
		final FindAllCustomersCommandHandler handler = (FindAllCustomersCommandHandler) this.handlerResolver.resolve(command);
		final List<Customer> customers = handler.handle(command);
		return customers.stream().map(customer -> this.converter.convert(customer)).collect(Collectors.toList());
	}


}
