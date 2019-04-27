package com.altran.rmleite.barcelonaTest.exception;


public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(Throwable throwable) {
		super(throwable.getMessage() + " - " + throwable.getLocalizedMessage());
	}
	
	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public Throwable getCause() {
		return super.getCause();
	}
	
   
}
