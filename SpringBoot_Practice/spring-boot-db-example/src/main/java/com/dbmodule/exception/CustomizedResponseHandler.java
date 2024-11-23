package com.dbmodule.exception;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomizedResponseHandler {
	Logger log = LoggerFactory.getLogger(CustomizedResponseHandler.class);

	//Class for managing all Exceptions...
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
				req.getDescription(false));
		log.info("Detailed information About Exception: "+ex);
		log.info("Exception occurred at: " + req.getDescription(false) + " || Exception: " + ex.getClass()
				+ " || ExceptionMessage: " + ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//Class for managing UserDetailsNotFound Exceptions...
	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundExceptions(UserDetailsNotFoundException ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
				req.getDescription(false));
		log.info("Exception occurred at: " + req.getDescription(false) + " ExceptionMessage: " + ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	//Class for managing validation Exceptions...
	@ExceptionHandler(TransactionSystemException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(TransactionSystemException ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), "Validation Failed",
				ex.getRootCause().toString());
		log.info("Exception occurred at: " + req.getDescription(false) + " || Exception: " + ex.getClass()
				+ " || ExceptionMessage: " + ex.getRootCause().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
