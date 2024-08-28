package com.project.project.exception;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final HttpStatus httpStatus;

    public InvalidArgumentException(String message) {
	super(message);
	this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public InvalidArgumentException(String message, HttpStatus httpStatus) {
	super(message);
	this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
	return httpStatus;
    }
}
