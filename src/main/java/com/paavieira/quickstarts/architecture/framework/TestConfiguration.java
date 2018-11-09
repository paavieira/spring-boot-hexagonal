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
		Arrays.asList("Messi,Lionel,messi@barcelona.com;Ronaldo,Cristiano,cr7@realmadrid.com".split(";")).forEach(s -> {
			final String[] data = s.split(",");
			final CustomerEntity customer = new CustomerEntity(data[1], data[0], data[2]);
			if (!customerRepository.exists(Example.of(customer))) {
				customerRepository.save(customer);
			}
		});
	}

}