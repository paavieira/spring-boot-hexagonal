package com.paavieira.quickstarts.customer.domain;

import com.paavieira.quickstarts.architecture.domain.Command;

public class FindCustomerCommand implements Command {

	private final String id;

	public FindCustomerCommand(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
