package com.example.springsecuritysection9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug=true)
public class BankBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBackEndApplication.class, args);
	}
}
