package com.github.jbrasileiro.primso.transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jbrasileiro.primso.api.TimeProvider;
import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final TimeProvider time;

    @Autowired
    public TransactionService(
        TimeProvider time,
        TransactionRepository repository) {
        super();
        this.time = time;
        this.repository = repository;
    }

    public Transaction save(
        UUID uuid,
        TransactionPOSTRequest message) {
        Transaction build = Transaction
                .builder()
                .idAccount(message.getAccountId())
                .idOperationType(message.getOperationTypeId())
                .uuidMessage(uuid)
                .amount(message.getAmount())
                .eventDate(time.nowLocalDateTime())
                .build();
        return repository.save(build);        
    }
}
