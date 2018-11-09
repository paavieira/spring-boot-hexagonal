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
@Profile("development")
public class DevelopmentConfiguration {

	@Autowired
	private CustomerEntityRepository repository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Arrays.asList("Smith,Adam,asmith@money.com;Marx,Karl,kmarx@comunist.gov".split(";")).forEach(s -> {
			final String[] data = s.split(",");
			final CustomerEntity customer = new CustomerEntity(data[1], data[0], data[2]);
			if (!repository.exists(Example.of(customer))) {
				repository.save(customer);
			}
		});
	}

}