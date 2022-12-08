package com.example.springbootmongo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springbootmongo.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RequestExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {
		final int status = HttpStatus.NOT_FOUND.value();
		final String message = e.getMessage();
		final String path = request.getRequestURI();
		final StandardError error = new StandardError(status, message, path);
		return ResponseEntity.status(status).body(error);
	}
}
