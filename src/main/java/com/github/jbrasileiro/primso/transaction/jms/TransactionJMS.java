package com.github.jbrasileiro.primso.transaction.jms;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;

@Component
public class TransactionJMS {
    
    private final JMSOutput output;

    @Autowired
    public TransactionJMS(
        JMSOutput output) {
        super();
        this.output = output;
    }

    public UUID sendMessage(
        TransactionPOSTRequest request) {
        UUID uuid = UUID.randomUUID();
        Message<TransactionPOSTRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader("UUID", uuid)
                .build();
        output.channel().send(message);
        return uuid;
    }
    
    
    
    
}
