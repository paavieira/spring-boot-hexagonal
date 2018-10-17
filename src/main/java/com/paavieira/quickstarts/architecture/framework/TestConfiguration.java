package com.paavieira.quickstarts.architecture.framework;

import java.util.Arrays;

import com.paavieira.quickstarts.customer.framework.CustomerEntity;
import com.paavieira.quickstarts.customer.framework.CustomerEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;

@Configuration
@Profile("test")
public class TestConfiguration {

	@Autowired
	private CustomerEntityRepository customerRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Arrays.asList("Messi,Lionel;Ronaldo,Cristiano".split(";")).forEach(fullName -> {
			final String[] names = fullName.split(",");
			final CustomerEntity customer = new CustomerEntity(names[1], names[0]);
			if (!customerRepository.exists(Example.of(customer))) {
				customerRepository.save(customer);
			}
		});
	}

}