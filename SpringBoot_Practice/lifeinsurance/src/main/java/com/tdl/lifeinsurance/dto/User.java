package com.tdl.lifeinsurance.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class User {
	private int id;
	private String name;
	private String city;
	private long pinCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name =" + name + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

}