package com.dbmodule.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.dbmodule.model.JourneyStatusPayload;
import com.dbmodule.service.ThirdPartyService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/rest_template")
public class ThirdPartyController {
	@Autowired
	private ThirdPartyService thirdPartyService;
	
	@GetMapping("/sample_call")
	public List<Object> sampleCall() {
		String uriString = "http://localhost:8082/jpa/com/get_all";
		RestTemplate restTemplate = new RestTemplate();
		Object[] callOutput = restTemplate.getForObject(uriString, Object[].class);
		return Arrays.asList(callOutput);
	}
	
	@PostMapping("/journey_status")
	public ResponseEntity<JsonNode> journeyStatus(@RequestBody JourneyStatusPayload body) {
		return thirdPartyService.getJourneyStatus(body);
	}
	
}
