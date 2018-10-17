package com.paavieira.quickstarts.customer.framework;

import com.paavieira.quickstarts.architecture.framework.BadRequestException;
import com.paavieira.quickstarts.customer.domain.InvalidCustomerName;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	private CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseBody
	public CustomerEntity create(@RequestBody(required = true) CustomerEntity customer) {

		try {
			return service.save(customer);
		} catch (InvalidCustomerName e) {
			throw new BadRequestException(e);
		}

	}

}
