package com.github.jbrasileiro.primso.api.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import com.github.jbrasileiro.primso.transaction.jms.JMSInput;
import com.github.jbrasileiro.primso.transaction.jms.JMSOutput;

@EnableBinding({
	JMSOutput.class,
	JMSInput.class
})
@Configuration
public class RabbitMQConfiguration {
}
