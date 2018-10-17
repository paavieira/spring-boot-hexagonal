package com.paavieira.quickstarts.architecture.domain;

public interface Repository<M extends Model> {

	M save(M customer);

}