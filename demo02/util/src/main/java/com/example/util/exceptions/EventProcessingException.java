package com.example.util.exceptions;

public class EventProcessingException extends RuntimeException {
	private static final long serialVersionUID = -629684732087061145L;

	public EventProcessingException() {
	}

	public EventProcessingException(String message) {
		super(message);
	}

	public EventProcessingException(String message, Throwable cause) {
		super(message, cause);
	}

	public EventProcessingException(Throwable cause) {
		super(cause);
	}
}
