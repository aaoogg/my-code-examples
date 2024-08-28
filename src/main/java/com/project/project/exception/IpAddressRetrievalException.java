package com.project.project.exception;

public class IpAddressRetrievalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IpAddressRetrievalException(String message) {
	super(message);
    }

    public IpAddressRetrievalException(String message, Throwable cause) {
	super(message, cause);
    }
}
