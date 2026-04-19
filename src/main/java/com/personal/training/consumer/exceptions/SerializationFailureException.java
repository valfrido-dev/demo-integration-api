package com.personal.training.consumer.exceptions;

public class SerializationFailureException extends RuntimeException {
    public SerializationFailureException(String message) {
        super(message);
    }
}
