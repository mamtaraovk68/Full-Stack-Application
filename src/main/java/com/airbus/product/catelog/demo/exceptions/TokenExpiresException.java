package com.airbus.product.catelog.demo.exceptions;

public class TokenExpiresException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenExpiresException(String message) {
		super(message);
	}

}
