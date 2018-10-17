package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.customer.application.CreateCustomerCommandHandler;
import com.paavieira.quickstarts.customer.domain.CreateCustomerCommand;
import com.paavieira.quickstarts.customer.domain.Customer;

import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {

	private CreateCustomerCommandHandler handler;
	private CustomerEntityConverter converter;

	public CreateCustomerService(
		CustomerRepository repository,
		CustomerEntityConverter converter
	) {
		this.handler = new CreateCustomerCommandHandler(repository); // TODO: how to inject the handler without any framework dependencies?
		this.converter = converter;
	}

	public CustomerEntity save(final CustomerEntity entity) {
		final CreateCustomerCommand command = new CreateCustomerCommand(entity.getFirstName(), entity.getLastName());
		final Customer customer = this.handler.handle(command).get(0);
		return this.converter.convert(customer);
	}

}
