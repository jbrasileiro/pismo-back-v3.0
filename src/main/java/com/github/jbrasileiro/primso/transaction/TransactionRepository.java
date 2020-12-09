package com.github.jbrasileiro.primso.transaction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository
    extends
    JpaRepository<Transaction, UUID> {
}
