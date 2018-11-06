package com.paavieira.quickstarts.architecture.domain;

import java.util.List;
import java.util.Optional;

public interface Repository<M extends Model> {

	M save(M model);

	Optional<M> find(String id);

	List<M> findAll();

}