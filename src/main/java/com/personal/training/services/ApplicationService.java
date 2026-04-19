package com.personal.training.services;

import com.personal.training.consumer.service.CepConsumerService;
import com.personal.training.consumer.service.CidadesConsumerService;
import com.personal.training.endpoints.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final CepConsumerService cepConsumerService;
    private final CidadesConsumerService cidadesConsumerService;


    public List<ApplicationResponse> list() {
        var ceps = cepConsumerService.listCeps();
        var cidades = cidadesConsumerService.listCidades();
        return null;
    }

    public ApplicationResponse getCepInfo(String cep) {
        return null;
    }

}
