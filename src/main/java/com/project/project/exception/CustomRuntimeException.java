package com.project.project.exception;

import java.util.Map;

public class CustomRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Map<String, Object> additionalData;

    public CustomRuntimeException() {
	super();
	this.additionalData = null;
    }

    public CustomRuntimeException(String message) {
	super(message);
	this.additionalData = null;
    }

    public CustomRuntimeException(String message, Throwable cause) {
	super(message, cause);
	this.additionalData = null;
    }

    public Map<String, Object> getAdditionalData() {
	return additionalData;
    }
}
