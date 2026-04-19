package com.personal.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCepNaoEncontrado(
            CepNotFoundException ex, WebRequest request) {

        Map<String, String> body = new HashMap<>();
        body.put("status", "404");
        body.put("error", "Not Found");
        body.put("mesage", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
