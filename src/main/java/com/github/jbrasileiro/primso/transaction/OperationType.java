package com.github.jbrasileiro.primso.transaction;

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
public class OperationType {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_OPERATION_TYPE")
    @SequenceGenerator(
        name = "SEQ_OPERATION_TYPE",
        sequenceName = "SEQ_OPERATION_TYPE",
        allocationSize = 1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column
    private String description;
}
