package com.example.springbootmongo.exceptions;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Object id) {
		super(message.formatted(id));
	}

}
