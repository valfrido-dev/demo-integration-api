package com.personal.training.mock.service;

import org.springframework.stereotype.Service;

@Service
public class CidadesMockService {
    private static final String MOCK_XML = """
        <List>
          <cidade>
            <nome>Belo Horizonte</nome>
            <estado>MG</estado>
            <populacao>2500000</populacao>
          </cidade>
          <cidade>
            <nome>São Paulo</nome>
            <estado>SP</estado>
            <populacao>12000000</populacao>
          </cidade>
          <cidade>
            <nome>Rio de Janeiro</nome>
            <estado>RJ</estado>
            <populacao>6700000</populacao>
          </cidade>
        </List>
        """;

    public String getMockCidadesXml() {
        return MOCK_XML;
    }
}
