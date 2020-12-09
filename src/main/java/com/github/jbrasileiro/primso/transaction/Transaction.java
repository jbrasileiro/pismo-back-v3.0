package com.github.jbrasileiro.primso.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_TRANSACTION")
    @SequenceGenerator(
        name = "SEQ_TRANSACTION",
        sequenceName = "SEQ_TRANSACTION",
        allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "UUID_MESSAGE")
    private UUID uuidMessage;
    @Column
    private Long idAccount;
    @Column
    private Long idOperationType;
    @Column
    private BigDecimal amount;
    @Column
    private LocalDateTime eventDate;
    
}
