package com.ailab.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class CustomerAlreadyExists extends ErrorResponseException {
    public CustomerAlreadyExists(String message){
        super(HttpStatus.BAD_REQUEST, asProblemDetail(message), null);

    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message);
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(message);
        problemDetail.setType(URI.create("http://localhost:8080/api/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }}
