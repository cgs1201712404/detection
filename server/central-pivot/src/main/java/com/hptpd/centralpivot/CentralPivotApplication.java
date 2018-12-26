package com.hptpd.centralpivot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.cors.CorsConfiguration.ALL;

/**
 * @author 彭诗杰
 */
@SpringBootApplication
public class CentralPivotApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CentralPivotApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(ALL)
				.allowedMethods(ALL)
				.allowedHeaders(ALL)
				.allowCredentials(true);
	}

}

