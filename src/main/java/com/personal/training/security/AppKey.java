package com.personal.training.security;

import lombok.Data;

@Data
public class AppKey {
    private String keyHash;
    private String owner;
    private Long limite;
    private Long consumo;
}
