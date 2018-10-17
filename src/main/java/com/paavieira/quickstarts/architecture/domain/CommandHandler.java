package com.paavieira.quickstarts.architecture.domain;

import java.util.List;

public interface CommandHandler<C extends Command, M extends Model> {

	List<M> handle(C command);

}