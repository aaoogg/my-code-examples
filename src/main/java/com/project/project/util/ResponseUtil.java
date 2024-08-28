package com.project.project.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.project.constants.StringConstants;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> buildSuccessResponse(HttpStatus status, Map<String, Object> body) {
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<Map<String, Object>> buildSuccessResponse(HttpStatus status, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(StringConstants.MESSAGE, message);
        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(StringConstants.MESSAGE, message);
        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message, String customMessage) {
        Map<String, Object> response = new HashMap<>();
        response.put(StringConstants.MESSAGE, message);
        if (customMessage != null) {
            response.put(StringConstants.CUSTOM, customMessage);
        }
        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(int statusCode, String message) {
        HttpStatus status = HttpStatus.valueOf(statusCode);
        return buildErrorResponse(status, message);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String[] messages) {
        Map<String, Object> response = new HashMap<>();
        response.put(StringConstants.ERRORS, messages);
        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(int statusCode, String[] messages) {
        HttpStatus status = HttpStatus.valueOf(statusCode);
        return buildErrorResponse(status, messages);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, Map<String, Object> response) {
        return ResponseEntity.status(status).body(response);
    }
}
