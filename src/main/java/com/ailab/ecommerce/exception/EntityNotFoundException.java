package com.ailab.ecommerce.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class EntityNotFoundException extends ErrorResponseException {



    public EntityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, asProblemDetail(message), null);
    }

    public EntityNotFoundException(Class<?> entityName, Long id) {
        super(HttpStatus.NOT_FOUND, asProblemDetail(entityName.getSimpleName() + " with id " + id + " not found"), null);
    }

    public EntityNotFoundException(Class<?> entityName, String by) {
        super(HttpStatus.NOT_FOUND, asProblemDetail(entityName.getSimpleName() + " not found: " + by), null);
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(message);
        problemDetail.setType(URI.create("http://localhost:8080/api/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
