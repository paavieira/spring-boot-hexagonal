package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.customer.application.CreateCustomerCommandHandler;
import com.paavieira.quickstarts.customer.domain.CreateCustomerCommand;
import com.paavieira.quickstarts.customer.domain.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private CreateCustomerCommandHandler handler;

	public CustomerService(CustomerRepository repository) {
		// TODO: how to inject the handler without any framework dependencies?
		this.handler = new CreateCustomerCommandHandler(repository);
	}

	public CustomerEntity save(CustomerEntity entity) {
		final CreateCustomerCommand command = new CreateCustomerCommand(entity.getFirstName(), entity.getLastName());
		final Customer customer = this.handler.handle(command).get(0);
		final CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customer.getId());
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());
		return customerEntity;
	}

}
