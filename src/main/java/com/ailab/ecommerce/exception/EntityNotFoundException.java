package com.ailab.ecommerce.exception;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityName, Long id) {
        super(entityName.getSimpleName() + " not found: " + id);
    }
    public EntityNotFoundException(Class<?> entityName, String by) {
        super(entityName.getSimpleName() + " not found: " + by);
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
