package com.paavieira.quickstarts.architecture.domain;

import java.util.List;

public interface Repository<M extends Model> {

	M save(M customer);

	List<M> findAll();

}