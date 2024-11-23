package com.dbmodule.model;


public class RequestPayload {
	String customer_identifier;
	String journey_id;
	
	public String getCustomer_identifier() {
		return customer_identifier;
	}
	public void setCustomer_identifier(String customer_identifier) {
		this.customer_identifier = customer_identifier;
	}
	public String getJourney_id() {
		return journey_id;
	}
	public void setJourney_id(String journey_id) {
		this.journey_id = journey_id;
	}
	public RequestPayload() {
		
	}
	public RequestPayload(String customer_identifier, String journey_id) {
		super();
		this.customer_identifier = customer_identifier;
		this.journey_id = journey_id;
	}
}
