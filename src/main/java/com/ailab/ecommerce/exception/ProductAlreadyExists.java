package com.ailab.ecommerce.exception;

public class ProductAlreadyExists extends RuntimeException{
    public ProductAlreadyExists(String message){
        super(message);
    }
}
