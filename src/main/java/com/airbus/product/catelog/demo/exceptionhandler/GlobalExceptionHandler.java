package com.airbus.product.catelog.demo.exceptionhandler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.airbus.product.catelog.demo.exceptions.IncorrectPasswordException;
import com.airbus.product.catelog.demo.exceptions.LoginException;
import com.airbus.product.catelog.demo.exceptions.ProductManipulationException;
import com.airbus.product.catelog.demo.exceptions.TokenExpiresException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER =  LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<Response> loginPasswordExceptionHandler(IncorrectPasswordException exception,
			HttpServletRequest request) {
		LOGGER.info("Exception encountered at " + request.getRequestURI() + exception.getMessage());
		Response response = new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(-1);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Response> loginExceptionHandler(LoginException exception,
			HttpServletRequest request) {
		LOGGER.info("Exception encountered at " + request.getRequestURI() + exception.getMessage());
		Response response = new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(-2);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response> userNotFoundExceptionHandler(UserNotFoundException exception,
			HttpServletRequest request) {
		LOGGER.info("Exception encountered at " + request.getRequestURI() + exception.getMessage());
		Response response = new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(-3);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductManipulationException.class)
	public ResponseEntity<Response> productManipulationException(ProductManipulationException exception,
			HttpServletRequest request) {
		LOGGER.info("Exception encountered at " + request.getRequestURI() + exception.getMessage());
		Response response = new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(-4);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(TokenExpiresException.class)
	public ResponseEntity<Response> tokenExpiresException(TokenExpiresException exception,
			HttpServletRequest request) {
		LOGGER.info("Exception encountered at " + request.getRequestURI() + exception.getMessage());
		Response response = new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(-5);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
