package com.example.springbootmongo.controllers;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String type;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Integer status, String type, String message, String path) {
		super();
		this.status = status;
		this.type = type;
		this.message = message;
		this.path = path;
	}

	public String getTimestamp() {
		return Instant.now().toString();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
