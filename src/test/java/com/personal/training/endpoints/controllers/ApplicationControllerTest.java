package com.personal.training.endpoints.controllers;

import com.personal.training.endpoints.dto.ApplicationResponse;
import com.personal.training.exceptions.CepNotFoundException;
import com.personal.training.exceptions.RequestInvalidParameterException;
import com.personal.training.services.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationControllerTest {

    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private ApplicationController controller;

    private ApplicationResponse response;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        response = new ApplicationResponse(123456L, "Rua Teste", "São Paulo", "SP", "12000000");
    }

    @Test
    void testListAll() {
        when(applicationService.listAll()).thenReturn(List.of(response));

        List<ApplicationResponse> result = controller.listAll();

        assertEquals(1, result.size());
        assertEquals("São Paulo", result.getFirst().municipio());
    }

    @Test
    void testFindByCepValid() {
        when(applicationService.getCepInfo(123456L)).thenReturn(response);

        ApplicationResponse result = controller.findByCep("123456");

        assertEquals(123456L, result.cep());
        assertEquals("SP", result.estado());
    }

    @Test
    void testFindByCepInvalidParameter() {
        assertThrows(RequestInvalidParameterException.class, () -> controller.findByCep(" "));
    }

    @Test
    void testFindByCepNotFound() {
        when(applicationService.getCepInfo(999999L)).thenThrow(new CepNotFoundException(999999L));

        assertThrows(CepNotFoundException.class, () -> controller.findByCep("999999"));
    }
}

