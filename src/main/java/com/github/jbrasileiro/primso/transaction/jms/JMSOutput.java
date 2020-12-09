package com.github.jbrasileiro.primso.transaction.jms;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface JMSOutput {

	@Output("transactionOutput")
	MessageChannel channel();
}
