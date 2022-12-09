package com.example.springbootmongo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springbootmongo.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RequestExceptionHandler {
	
	private ResponseEntity<StandardError> createResponseEntity(
			HttpStatus status, Throwable e, HttpServletRequest request) {
		final int statusValue = status.value();
		final StandardError error = new StandardError(statusValue, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(statusValue).body(error);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {
		return createResponseEntity(HttpStatus.NOT_FOUND, e, request);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<StandardError> throwable(Throwable e, HttpServletRequest request) {
		return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e, request);
	}
	
}
