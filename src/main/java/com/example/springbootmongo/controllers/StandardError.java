package com.example.springbootmongo.controllers;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String error;
	private String path;

	public StandardError() {
	}

	public StandardError(Integer status, String error, String path) {
		super();
		this.status = status;
		this.error = error;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
