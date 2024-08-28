package com.project.project.exception;

public class IllegalArgumentExceptionCustom extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IllegalArgumentExceptionCustom(String message) {
        super(message);
    }
}
