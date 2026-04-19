package com.personal.training.consumer.dto;

public class CepDTO {
    private long numero;
    private String endereco;
    private String municipio;
    private String estado;

    public CepDTO() {}

    public CepDTO(long numero, String endereco, String municipio, String estado) {
        this.numero = numero;
        this.endereco = endereco;
        this.municipio = municipio;
        this.estado = estado;
    }

    public long getNumero() { return numero; }
    public void setNumero(long numero) { this.numero = numero; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

