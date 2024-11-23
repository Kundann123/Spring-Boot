package com.sampleproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sampleproject.dao.AddNumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//for RESTful APIs
@RestController
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/get")
	public String demo() {
		return "Hello World";
	}
	
	@PostMapping("/add")
	public int add(@RequestBody AddNumbers number) {
		int addition = number.getFirstNumber()+ number.getSecondNumber();
		log.info("Addition of numbers : "+addition);
		return addition;
	}
}
