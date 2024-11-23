package com.tdl.lifeinsurance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.tdl.lifeinsurance.dto.User;

@RestController
public class CrudController {
	
	@Autowired
	ObjectMapper objectMapper;
	
	//Checks the health
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "OK";
	}
	
	
	//Get the request which is given as string
	@PostMapping("/getRequest")
	public String getRequest(@RequestBody String str){
		return str;
	}
	
	//Get the Json object which is entered
	@PostMapping("/getJson")
	public User getJson(@RequestBody User user){
		return user;
	}
	
	//Get any Json which given as input
    @PostMapping("/getAnyJson")
    public Object getAnyJson(@RequestBody Object jsonData){
        return jsonData;
    }
	

}
