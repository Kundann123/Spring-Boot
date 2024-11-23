package com.dbmodule.model;


public class JourneyStatusPayload {

	PlatformParameters platformParameters;
	RequestPayload requestPayload;
	
	public PlatformParameters getPlatformParameters() {
		return platformParameters;
	}
	public void setPlatformParameters(PlatformParameters platformParameters) {
		this.platformParameters = platformParameters;
	}
	public RequestPayload getRequestPayload() {
		return requestPayload;
	}
	public void setRequestPayload(RequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}
	
	public JourneyStatusPayload() {
		
	}
	public JourneyStatusPayload(PlatformParameters platformParameters, RequestPayload requestPayload) {
		super();
		this.platformParameters = platformParameters;
		this.requestPayload = requestPayload;
	}
}
