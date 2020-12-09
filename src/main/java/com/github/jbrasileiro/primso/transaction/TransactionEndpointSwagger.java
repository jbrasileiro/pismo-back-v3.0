package com.github.jbrasileiro.primso.transaction;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;

public interface TransactionEndpointSwagger {

    ResponseEntity<Transaction> post(
        @Valid
        TransactionPOSTRequest request);
}
