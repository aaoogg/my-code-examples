package com.project.project.exception;

import java.util.Map;

import org.hibernate.LazyInitializationException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.project.project.constants.MessageConstants;
import com.project.project.util.ResponseUtil;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.TransactionRequiredException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.BAD_REQUEST_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String, Object>> handleUnauthorizedException(UnauthorizedException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage(),
		MessageConstants.UNAUTHORIZED_ERROR);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Map<String, Object>> handleForbiddenException(ForbiddenException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.FORBIDDEN, e.getMessage(), MessageConstants.FORBIDDEN_ERROR);
    }

    @ExceptionHandler(CustomForbiddenException.class)
    public ResponseEntity<Map<String, Object>> handleCustomForbiddenException(CustomForbiddenException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.FORBIDDEN, e.getAdditionalData().toString(),
		MessageConstants.FORBIDDEN_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(), MessageConstants.NOT_FOUND_ERROR);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidArgumentException(InvalidArgumentException e) {
	return ResponseUtil.buildErrorResponse(e.getHttpStatus(), e.getMessage(),
		MessageConstants.INVALID_ARGUMENT_ERROR);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> handleConflict(ConflictException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(), MessageConstants.CONFLICT_ERROR);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<Map<String, Object>> handleUnprocessableEntity(UnprocessableEntityException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(),
		MessageConstants.UNPROCESSABLE_ENTITY_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, Object>> handleNullPointerException(NullPointerException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.NULL_POINTER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.ILLEGAL_ARGUMENT_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
		MessageConstants.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(),
		MessageConstants.ENTITY_NOT_FOUND_ERROR);
    }

    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<Map<String, Object>> handleOptimisticLockException(OptimisticLockException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
		MessageConstants.OPTIMISTIC_LOCK_ERROR);
    }

    @ExceptionHandler(TransactionRequiredException.class)
    public ResponseEntity<Map<String, Object>> handleTransactionRequiredException(TransactionRequiredException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.TRANSACTION_REQUIRED_ERROR);
    }

    @ExceptionHandler(LazyInitializationException.class)
    public ResponseEntity<Map<String, Object>> handleLazyInitializationException(LazyInitializationException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
		MessageConstants.LAZY_INITIALIZATION_ERROR);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEntityExistsException(EntityExistsException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
		MessageConstants.ENTITY_EXISTS_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.CONSTRAINT_VIOLATION_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(
	    DataIntegrityViolationException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
		MessageConstants.DATA_INTEGRITY_VIOLATION_ERROR);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Map<String, Object>> handlePropertyValueException(PropertyValueException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(),
		MessageConstants.PROPERTY_VALUE_ERROR);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<Map<String, Object>> handleDataException(DataException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(), MessageConstants.DATA_ERROR);
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Map<String, Object>> handleNoResultException(NoResultException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(), MessageConstants.NO_RESULT_ERROR);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, Object>> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.PAYLOAD_TOO_LARGE, e.getMessage(),
		MessageConstants.MAX_UPLOAD_SIZE_EXCEEDED_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoHandlerFoundException(NoHandlerFoundException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(),
		MessageConstants.NO_HANDLER_FOUND_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(
	    HttpRequestMethodNotSupportedException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage(),
		MessageConstants.METHOD_NOT_SUPPORTED_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(AccessDeniedException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.FORBIDDEN, e.getMessage(),
		MessageConstants.ACCESS_DENIED_ERROR);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalStateException(IllegalStateException e) {
	return ResponseUtil.buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
		MessageConstants.ILLEGAL_STATE_ERROR);
    }
}
