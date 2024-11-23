package com.dbmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dbmodule.model.JourneyStatusPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ThirdPartyService {
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<JsonNode> getJourneyStatus(JourneyStatusPayload body) {
		String uriString = "http://icintegrationplatform.dev-r2-fs.tataneupolicy.com/api/v1/integration/lifesave/journeystatus/1212121223";  
		ResponseEntity<String> response = restTemplate.postForEntity(uriString, body, String.class);
		System.out.println("API Status Code === "+response.getStatusCode());
//		System.out.println("API Response === "+response);
		
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.getBody());
            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(response.getStatusCode()).body(null);
        }
	}
 }
