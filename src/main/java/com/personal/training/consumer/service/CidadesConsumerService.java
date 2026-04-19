package com.personal.training.consumer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.personal.training.consumer.dto.CidadeDTO;
import com.personal.training.consumer.exceptions.SerializationFailureException;
import com.personal.training.mock.service.CidadesMockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CidadesConsumerService {

    private final CidadesMockService cidadesApi;
    private final XmlMapper xmlMapper  = new XmlMapper();

    public List<CidadeDTO> listCidades() {
        var response = cidadesApi.getMockCidadesXml();
        try {
            return xmlMapper.readValue(response,
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, CidadeDTO.class));
        } catch (JsonProcessingException e) {
            log.error("Erro ao serializar/processar a resposta da consulta Cidades");
            throw new SerializationFailureException("Erro ao consultar lista de Cidades. Tente novamente mais tarde");
        }
    }
}
