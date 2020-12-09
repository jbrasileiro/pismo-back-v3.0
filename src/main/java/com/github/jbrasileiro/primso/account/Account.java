package com.github.jbrasileiro.primso.account;

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
public class Account {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_ACCOUNT")
    @SequenceGenerator(
        name = "SEQ_ACCOUNT",
        sequenceName = "SEQ_ACCOUNT",
        allocationSize = 1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;
}
