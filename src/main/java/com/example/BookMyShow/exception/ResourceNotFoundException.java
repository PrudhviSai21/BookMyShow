package com.example.BookMyShow.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    String resourceName;
    String fieldName;
    int fieldValue;
    String name;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer userId) {
        super(String.format("%s not found with %s :%s",resourceName,fieldName,userId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = userId;
    }
    public ResourceNotFoundException(String resourceName, String fieldName, String name) {
        super(String.format("%s not found with %s :%s",resourceName,fieldName,name));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.name = name;
    }

}