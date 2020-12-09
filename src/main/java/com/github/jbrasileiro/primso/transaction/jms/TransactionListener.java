package com.github.jbrasileiro.primso.transaction.jms;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.github.jbrasileiro.primso.transaction.TransactionService;
import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;

@Component
public class TransactionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionListener.class);

    private final TransactionService service;

    @Autowired
    public TransactionListener(
        TransactionService service) {
        super();
        this.service = service;
    }

    @StreamListener("transactionInput")
    public void readMessage(
        @Header(required = true, name = "UUID") final UUID uuid,
        @Payload final TransactionPOSTRequest message) {
        LOGGER.info("message {} received -> {}", uuid, message);
        service.save(uuid, message);
    }
}
