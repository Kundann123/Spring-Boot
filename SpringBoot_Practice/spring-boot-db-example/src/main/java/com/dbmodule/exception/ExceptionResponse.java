package com.dbmodule.exception;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {
	@JsonProperty
	LocalDate timeStamp;
	@JsonProperty
	String message;
	@JsonProperty
	String details;
	
	public ExceptionResponse(LocalDate timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
}
