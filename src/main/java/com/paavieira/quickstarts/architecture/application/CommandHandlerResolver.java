package com.paavieira.quickstarts.architecture.application;

import com.paavieira.quickstarts.architecture.domain.Command;
import com.paavieira.quickstarts.architecture.domain.CommandHandler;

public interface CommandHandlerResolver {

	CommandHandler<?, ?> resolve(Command command);

}