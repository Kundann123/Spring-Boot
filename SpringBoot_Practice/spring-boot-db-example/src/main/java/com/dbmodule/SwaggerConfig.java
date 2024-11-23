package com.dbmodule;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Sample APIs for DB operation")
				.version("1.0")
				.description("API for Spring Boot-DB example")
				.termsOfService("https://example.com/terms")
				.contact(new Contact().name("Kundan Mohite")
						.email("kundan.m@techouts.com")
						.url("https://example.com/contact")));
	}
}
