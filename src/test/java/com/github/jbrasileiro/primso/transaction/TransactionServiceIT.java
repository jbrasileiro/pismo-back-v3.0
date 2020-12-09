package com.github.jbrasileiro.primso.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.jbrasileiro.primso.TemplateIT;
import com.github.jbrasileiro.primso.api.TimeProvider;
import com.github.jbrasileiro.primso.transaction.to.TransactionPOSTRequest;


class TransactionServiceIT
    extends
    TemplateIT {

    private static final LocalDateTime NOW = LocalDateTime.of(2000, 12, 31, 23, 59, 59, 99999999);
    
    @Autowired
    private TransactionService service;
    @MockBean
    private TimeProvider time;
    
    @Test
    void save() {
        Transaction expected = Transaction.builder()
                .id(1L)
                .idAccount(2L)
                .idOperationType(3L)
                .uuidMessage(UUID.fromString("098f6bcd-4621-3373-8ade-4e832627b4f6"))
                .amount(BigDecimal.valueOf(99.99))
                .eventDate(NOW)
                .build();
        UUID uuid = UUID.nameUUIDFromBytes("test".getBytes());
        TransactionPOSTRequest message = TransactionPOSTRequest
                .builder() 
                .accountId(2L)
                .operationTypeId(3L)
                .amount(BigDecimal.valueOf(99.99))
                .build();
        
        Mockito
            .when(time.nowLocalDateTime())
            .thenReturn(NOW);
        
        Transaction result = service.save(uuid, message);
        Assertions.assertEquals(expected, result);
    }
}
