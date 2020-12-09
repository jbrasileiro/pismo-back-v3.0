package com.github.jbrasileiro.primso.transaction;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.jbrasileiro.primso.transaction.jms.TransactionJMS;
import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;

@RestController
@RequestMapping("/transactions")
public class TransactionEndpoint
    implements
    TransactionEndpointSwagger {
    
    private final TransactionJMS jms;
    
    @Autowired
    public TransactionEndpoint(
        TransactionJMS jms) {
        super();
        this.jms = jms;
    }

    @PostMapping
    @Override
    public ResponseEntity<Transaction> post(
            @RequestBody TransactionPOSTRequest request
        ) {
        UUID uuid = jms.sendMessage(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/messageUUID/{id}")
                .buildAndExpand(uuid).toUri();
        return ResponseEntity.created(location).build();
    }
}
