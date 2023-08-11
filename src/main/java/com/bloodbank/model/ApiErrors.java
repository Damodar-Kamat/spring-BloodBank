package com.bloodbank.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	private String message;
	private HttpStatus status;
	private LocalDateTime timestamp;
	private String error;
	private int statusCode;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public ApiErrors(String message, HttpStatus status, LocalDateTime timestamp, String error,int statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", error=" + error
				+ ", statusCode=" + statusCode + "]";
	}
	
	
}
