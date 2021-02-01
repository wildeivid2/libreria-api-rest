package com.credibanco.assessment.library.exceptions;

public class LibroException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LibroException() {
		super();
	}
	
	public LibroException(String message) {
        super(message);
    }
	
	public LibroException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public LibroException(Throwable cause) {
        super(cause);
    }
	
}
