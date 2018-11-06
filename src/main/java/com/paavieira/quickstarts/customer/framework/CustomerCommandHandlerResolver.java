package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.architecture.application.CommandHandlerResolver;
import com.paavieira.quickstarts.architecture.domain.Command;
import com.paavieira.quickstarts.architecture.domain.CommandHandler;
import com.paavieira.quickstarts.architecture.framework.BadRequestException;
import com.paavieira.quickstarts.customer.application.CreateCustomerCommandHandler;
import com.paavieira.quickstarts.customer.application.FindAllCustomersCommandHandler;
import com.paavieira.quickstarts.customer.application.FindCustomerCommandHandler;
import com.paavieira.quickstarts.customer.domain.CreateCustomerCommand;
import com.paavieira.quickstarts.customer.domain.FindAllCustomersCommand;
import com.paavieira.quickstarts.customer.domain.FindCustomerCommand;

import org.springframework.stereotype.Component;

@Component
public class CustomerCommandHandlerResolver implements CommandHandlerResolver {

	private CustomerRepository repository;

	public CustomerCommandHandlerResolver(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public CommandHandler<?, ?> resolve(Command command) {
		if (command instanceof CreateCustomerCommand) {
			return new CreateCustomerCommandHandler(repository);
		} else if (command instanceof FindAllCustomersCommand) {
			return new FindAllCustomersCommandHandler(repository);
		} else if (command instanceof FindCustomerCommand) {
			return new FindCustomerCommandHandler(repository);
		} else {
			throw new BadRequestException();
		}
	}

}