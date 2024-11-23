package com.dbmodule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	public WebClient webClient() {
		/*
		 * DataBufferLimitException: Exceeded limit on max bytes to buffer webflux error.
		 * The ExchangeStrategies are used to resolve the above error since most codecs
		 * are limited to 256K by default. This calculates a new limit.
		 */	
		final int size = 16*1024*1024;
		final ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(codecs-> codecs.defaultCodecs().maxInMemorySize(size)
				).build();
		
		/*
		 * WebClient.builder() is the builder method to create webClient instance.
		 */	
		WebClient webClient = WebClient
				.builder()
				.defaultCookie("cookiekey", "cookievalue")
				.exchangeStrategies(strategies)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
//		WebClient webClient = WebClient.builder().build();
		
		return webClient;
	}
	
}
