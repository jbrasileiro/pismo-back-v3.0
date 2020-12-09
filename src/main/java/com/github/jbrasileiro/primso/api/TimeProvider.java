package com.github.jbrasileiro.primso.api;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class TimeProvider {

    public LocalDateTime nowLocalDateTime() {
        return LocalDateTime.now();
    }
}
