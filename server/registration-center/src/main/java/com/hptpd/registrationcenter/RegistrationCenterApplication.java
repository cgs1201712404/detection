package com.hptpd.registrationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.cors.CorsConfiguration.ALL;

/**
 * @author 彭诗杰
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationCenterApplication{

	public static void main(String[] args) {
		SpringApplication.run(RegistrationCenterApplication.class, args);
	}
}
