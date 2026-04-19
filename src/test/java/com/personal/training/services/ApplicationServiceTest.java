package com.personal.training.services;

import com.personal.training.consumer.dto.CepDTO;
import com.personal.training.consumer.dto.CidadeDTO;
import com.personal.training.consumer.service.CepConsumerService;
import com.personal.training.consumer.service.CidadesConsumerService;
import com.personal.training.endpoints.dto.ApplicationResponse;
import com.personal.training.exceptions.CepNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationServiceTest {

    @Mock
    private CepConsumerService cepConsumerService;

    @Mock
    private CidadesConsumerService cidadesConsumerService;

    @InjectMocks
    private ApplicationService applicationService;

    private CepDTO cepDTO;
    private CidadeDTO cidadeDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cepDTO = new CepDTO();
        cepDTO.setNumero(123456L);
        cepDTO.setEndereco("Rua Teste");
        cepDTO.setMunicipio("São Paulo");
        cepDTO.setEstado("SP");

        cidadeDTO = new CidadeDTO();
        cidadeDTO.setNome("São Paulo");
        cidadeDTO.setEstado("SP");
        cidadeDTO.setPopulacao(12000000L);
    }

    @Test
    void testListAll() {
        when(cepConsumerService.listCeps()).thenReturn(List.of(cepDTO));
        when(cidadesConsumerService.listCidades()).thenReturn(List.of(cidadeDTO));

        List<ApplicationResponse> responses = applicationService.listAll();

        assertEquals(1, responses.size());
        assertEquals("12000000", responses.getFirst().populacao());
    }

    @Test
    void testGetCepInfoFound() {
        when(cepConsumerService.listCeps()).thenReturn(List.of(cepDTO));
        when(cidadesConsumerService.listCidades()).thenReturn(List.of(cidadeDTO));

        ApplicationResponse response = applicationService.getCepInfo(123456L);

        assertEquals(123456L, response.cep());
        assertEquals("Rua Teste", response.endereco());
        assertEquals("12000000", response.populacao());
    }

    @Test
    void testGetCepInfoNotFound() {
        when(cepConsumerService.listCeps()).thenReturn(List.of());

        assertThrows(CepNotFoundException.class, () -> applicationService.getCepInfo(999999L));
    }
}
