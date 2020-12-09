package com.github.jbrasileiro.primso.account;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.jbrasileiro.primso.account.to.AccountPOSTRequest;

@RestController
@RequestMapping("/accounts")
public class AccountEndpoint
    implements
    AccountEndpointSwagger {
    
    private final AccountRepository repository;
    
    @Autowired
    public AccountEndpoint(
        AccountRepository repository) {
        super();
        this.repository = repository;
    }

    @PostMapping
    @Override
    public ResponseEntity<Account> post(
            @RequestBody AccountPOSTRequest request
        ) {
        Account account = repository.save(Account.builder()
            .documentNumber(request.getDocumentNumber())
            .build());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(account.getId()).toUri();
        return ResponseEntity.ok().location(location).body(account);
    }
    
    @GetMapping("/{accountId}")
    @Override
    public ResponseEntity<Account> find(
            @PathVariable final UUID accountId
        ) {
        return ResponseEntity.ok(repository.getOne(accountId));
    }
    
}
