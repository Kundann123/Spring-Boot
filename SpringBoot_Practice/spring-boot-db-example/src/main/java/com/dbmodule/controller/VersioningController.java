package com.dbmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbmodule.model.Name;
import com.dbmodule.model.Person1;
import com.dbmodule.model.Person2;

@RestController
public class VersioningController {
	/*URI Versioning*/
	@GetMapping("/v1/person")
	public Person1 person1() {
		return new Person1("Kundan Mohite");
	}

	@GetMapping("/v2/person")
	public Person2 person2() {
		return new Person2(new Name("Kundan", "Mohite"));
	}
	
	/* Versioning using Request Header */
	@GetMapping(value = "/person", headers = "API-Version=1")
	public Person1 header1() {
		return new Person1("Kundan Mohite");
	} 
	
	@GetMapping(value = "/person", headers = "API-Version=2")
	public Person2 header2() {
		return new Person2(new Name("Kundan", "Mohite"));
	}
}
