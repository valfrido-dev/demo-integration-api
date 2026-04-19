package com.personal.training.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.training.consumer.dto.CepDTO;
import com.personal.training.mock.service.CepMockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CepConsumerService {

    private final CepMockService cepApi;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<CepDTO> listCeps() {
        var response = cepApi.getMockCepJson();
        try {
            return objectMapper.readValue(response,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, CepDTO.class));
        } catch (JsonProcessingException e) {
            log.error("Erro ao deserializar a resposta da consulta CEP {}", );
            throw new RuntimeException("Erro ao consultar lista de Ceps. Tente novamente mais tarde");
        }
    }
}
