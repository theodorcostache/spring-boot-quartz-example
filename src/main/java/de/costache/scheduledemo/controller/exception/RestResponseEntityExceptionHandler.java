package de.costache.scheduledemo.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.costache.scheduledemo.controller.dto.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleControllerException(ControllerException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ErrorResponse(ex.getMessage(), ex.getErrorCode()), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
