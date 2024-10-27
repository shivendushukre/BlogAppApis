package com.blogApp.blog_app_apis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;

    private String fieldName;

    private Integer fieldValue;

    private String fieldValueString;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValueString));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueString = fieldValueString;
    }
}
