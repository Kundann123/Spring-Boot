package com.dbmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.dbmodule.model.Company;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/web_client")
public class WebClientController {
	
	@Autowired
	private WebClient webClient;

	@GetMapping("/sample")
	public Flux<Company> sampleWebClient() {
		return webClient.get()
				.uri("http://localhost:8082/jpa/com/get_all")
				.retrieve()
				.bodyToFlux(Company.class);
	}
}
