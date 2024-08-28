package com.project.project.exception;

import java.util.Map;

import com.project.project.constants.StringConstants;

public class CustomForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Map<String, Object> additionalData;

    public CustomForbiddenException(Map<String, Object> additionalData) {
	super(StringConstants.FORBIDDEN);
	this.additionalData = additionalData;
    }

    public Map<String, Object> getAdditionalData() {
	return additionalData;
    }
}
