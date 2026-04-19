package com.personal.training.endpoints.controllers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApplicationControllerIntegrationTest {


    @Test
    void testListAllEndpoint() {
        given().header("APP-KEY", "teste-secret-key")
                .accept("application/json")
                .when()
                .get("api/ceps/list")
                .then()
                .statusCode(200)
                .body("[0].municipio", equalTo("Belo Horizonte"));
    }

    @Test
    void testFindByCepEndpoint() {
        given().header("APP-KEY", "teste-secret-key")
                .accept("application/json")
                .queryParam("cep", "01001000")
                .when()
                .get("api/ceps/find")
                .then()
                .statusCode(200)
                .body("cep", equalTo(1001000))
                .body("estado", equalTo("SP"));
    }
}

