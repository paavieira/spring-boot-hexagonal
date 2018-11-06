package com.paavieira.quickstarts.customer.framework;

import java.util.List;
import java.util.stream.Collectors;

import com.paavieira.quickstarts.customer.application.FindCustomerCommandHandler;
import com.paavieira.quickstarts.customer.domain.Customer;
import com.paavieira.quickstarts.customer.domain.FindCustomerCommand;

import org.springframework.stereotype.Service;

@Service
public class FindCustomerService {

	private CustomerCommandHandlerResolver handlerResolver;
	private CustomerEntityConverter converter;

	public FindCustomerService(
		CustomerCommandHandlerResolver handlerResolver,
		CustomerEntityConverter converter
	) {
		this.handlerResolver = handlerResolver;
		this.converter = converter;
	}

	public List<CustomerEntity> find(final String id) {
		final FindCustomerCommand command = new FindCustomerCommand(id);
		final FindCustomerCommandHandler handler = (FindCustomerCommandHandler) this.handlerResolver.resolve(command);
		final List<Customer> customers = handler.handle(command);
		return customers.stream().map(customer -> this.converter.convert(customer)).collect(Collectors.toList());
	}


}
