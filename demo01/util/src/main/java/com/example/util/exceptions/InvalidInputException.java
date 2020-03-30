package com.example.util.exceptions;

public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 2639687325711549213L;

	public InvalidInputException() {}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}
}
