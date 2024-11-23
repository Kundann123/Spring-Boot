package com.dbmodule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	//RestTemplate is synchronous and blocking
	
    @Bean
   public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2CborHttpMessageConverter()));
		return restTemplate;
	}
}
