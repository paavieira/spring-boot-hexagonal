package com.paavieira.quickstarts.customer.framework;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerEntityRepository extends MongoRepository<CustomerEntity, String> {

}