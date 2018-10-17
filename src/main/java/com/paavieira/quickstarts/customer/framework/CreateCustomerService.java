package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.customer.application.CreateCustomerCommandHandler;
import com.paavieira.quickstarts.customer.domain.CreateCustomerCommand;
import com.paavieira.quickstarts.customer.domain.Customer;

import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {

	private CustomerCommandHandlerResolver handlerResolver;
	private CustomerEntityConverter converter;

	public CreateCustomerService(
		CustomerCommandHandlerResolver handlerResolver,
		CustomerEntityConverter converter
	) {
		this.handlerResolver = handlerResolver;
		this.converter = converter;
	}

	public CustomerEntity save(final CustomerEntity entity) {
		final CreateCustomerCommand command = new CreateCustomerCommand(entity.getFirstName(), entity.getLastName());
		final CreateCustomerCommandHandler handler = (CreateCustomerCommandHandler) this.handlerResolver.resolve(command);
		final Customer customer = handler.handle(command).get(0);
		return this.converter.convert(customer);
	}

}
