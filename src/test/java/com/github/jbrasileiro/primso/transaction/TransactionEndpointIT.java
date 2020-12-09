package com.github.jbrasileiro.primso.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.jbrasileiro.primso.TemplateIT;

class TransactionEndpointIT
    extends
    TemplateIT {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void transactionsPOST() throws Exception {

        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/transactions")
                .content("{\"account_id\": 0,\"amount\": 0,\"operation_type_id\": 0}")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}
