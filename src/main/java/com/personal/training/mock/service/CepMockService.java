package com.personal.training.mock.service;

import org.springframework.stereotype.Service;

@Service
public class CepMockService {
    private static final String MOCK_JSON =
            "[{" +
                    "  \"numero\": \"30140071\"," +
                    "  \"endereco\": \"Avenida Afonso Pena\"," +
                    "  \"municipio\": \"Belo Horizonte\"," +
                    "  \"estado\": \"MG\"" +
                    "}," +
                    "{" +
                    "  \"numero\": \"01001000\"," +
                    "  \"endereco\": \"Praça da Sé\"," +
                    "  \"municipio\": \"São Paulo\"," +
                    "  \"estado\": \"SP\"" +
                    "}," +
                    "{" +
                    "  \"numero\": \"20040030\"," +
                    "  \"endereco\": \"Rua da Assembleia\"," +
                    "  \"municipio\": \"Rio de Janeiro\"," +
                    "  \"estado\": \"RJ\"" +
                    "}]";

    public String getMockCepJson() {
        return MOCK_JSON;
    }

}
