package com.ailab.ecommerce.exceptions;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entityName, Long id) {
        super(entityName + " not found: " + id);
    }
    public EntityNotFoundException(Class entityName, String by) {
        super(entityName + " not found: " + by);
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
