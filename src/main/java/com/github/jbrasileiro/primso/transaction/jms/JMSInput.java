package com.github.jbrasileiro.primso.transaction.jms;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface JMSInput {

	@Input("transactionInput")
	SubscribableChannel input();
}
