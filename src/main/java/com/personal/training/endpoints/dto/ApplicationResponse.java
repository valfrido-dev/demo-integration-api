package com.personal.training.endpoints.dto;



public record ApplicationResponse (
    long cep,
    String endereco,
    String municipio,
    String estado,
    String populacao) {
}
