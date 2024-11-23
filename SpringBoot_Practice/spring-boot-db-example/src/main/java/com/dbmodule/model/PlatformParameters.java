package com.dbmodule.model;


public class PlatformParameters {
	String provider;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public PlatformParameters() {
		
	}
	public PlatformParameters(String provider) {
		super();
		this.provider = provider;
	}
}
