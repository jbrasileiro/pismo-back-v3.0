package com.github.jbrasileiro.primso.transaction.to;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.jbrasileiro.primso.api.json.BigDecimalSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionPOSTRequest {
    
    @NotNull
    @JsonProperty("account_id")
    private Long accountId;
    @NotNull
    @JsonProperty("operation_type_id")
    private Long operationTypeId;
    @NotNull
    @JsonSerialize(using = BigDecimalSerialize.class)
    private BigDecimal amount;
    
}
