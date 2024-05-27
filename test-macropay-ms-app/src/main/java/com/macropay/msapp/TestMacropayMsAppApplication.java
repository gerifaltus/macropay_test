package com.macropay.msapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;

@SpringBootApplication
public class TestMacropayMsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMacropayMsAppApplication.class, args);
	}

}
