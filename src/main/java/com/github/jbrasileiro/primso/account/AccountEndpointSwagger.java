package com.github.jbrasileiro.primso.account;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.github.jbrasileiro.primso.account.to.AccountPOSTRequest;

public interface AccountEndpointSwagger {

    ResponseEntity<Account> post(
        @Valid
        AccountPOSTRequest request);

    ResponseEntity<Account> find(
        UUID id);
}
