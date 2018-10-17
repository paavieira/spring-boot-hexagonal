package com.paavieira.quickstarts.customer.framework;

import java.util.List;

import com.paavieira.quickstarts.architecture.framework.BadRequestException;
import com.paavieira.quickstarts.customer.domain.InvalidCustomerName;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CreateCustomerService createService;
	private FindAllCustomersService findAllService;

	private CustomerController(CreateCustomerService createService, FindAllCustomersService findAllService) {
		this.createService = createService;
		this.findAllService = findAllService;
	}

	@PostMapping
	@ResponseBody
	public CustomerEntity create(@RequestBody(required = true) CustomerEntity customer) {

		try {
			return createService.save(customer);
		} catch (InvalidCustomerName e) {
			throw new BadRequestException(e);
		}

	}

	@GetMapping
	@ResponseBody
	public List<CustomerEntity> getCollection() {
		return findAllService.findAll();
	}

}
