package com.github.jbrasileiro.primso.account.to;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountPOSTRequest {

    @NotNull
    @JsonProperty("document_number")
    private Long documentNumber;
}
