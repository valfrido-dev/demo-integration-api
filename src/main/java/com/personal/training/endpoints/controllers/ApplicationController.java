package com.personal.training.endpoints.controllers;

import com.personal.training.endpoints.dto.ApplicationResponse;
import com.personal.training.exceptions.CepNotFoundException;
import com.personal.training.exceptions.RequestInvalidParameterException;
import com.personal.training.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ceps")
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ApplicationService service;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ApplicationResponse> listAll() {
        return service.listAll();
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponse findByCep(@RequestParam(name = "cep", required = true) String cep) {
        try {
            // Remove tudo que não for número
            var numeroCep = Long.parseLong(cep.replaceAll("\\D", ""));
            return service.getCepInfo(numeroCep);
        } catch (NumberFormatException e) {
            throw new RequestInvalidParameterException("cep", cep);
        }
    }

}
