package com.paavieira.quickstarts.customer.framework;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.paavieira.quickstarts.architecture.framework.BadRequestException;
import com.paavieira.quickstarts.architecture.framework.NotFoundException;
import com.paavieira.quickstarts.customer.domain.InvalidCustomerName;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CreateCustomerService createService;
	private FindCustomerService findService;
	private FindAllCustomersService findAllService;

	private CustomerController(
		CreateCustomerService createService,
		FindCustomerService findService,
		FindAllCustomersService findAllService
	) {
		this.createService = createService;
		this.findService = findService;
		this.findAllService = findAllService;
	}

	@PostMapping
	@ResponseBody
	public CustomerEntity create(@RequestBody(required = true) @Valid final CustomerEntity customer) {

		try {
			return createService.save(customer);
		} catch (InvalidCustomerName e) {
			throw new BadRequestException(e);
		}

	}

	@GetMapping("/{id}")
	@ResponseBody
	public List<CustomerEntity> getSingle(@PathVariable("id") final String id) {

		try {
			return findService.find(id);
		} catch (NoSuchElementException e) {
			throw new NotFoundException();
		}

	}

	@GetMapping
	@ResponseBody
	public List<CustomerEntity> getCollection() {
		return findAllService.findAll();
	}

}
