package com.personal.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestInvalidParameterException extends RuntimeException {
    public RequestInvalidParameterException(String parameter, String value) {
        super(String.format("Parâmetro da requisição inválido. %s: %s", parameter, value));
    }
}
