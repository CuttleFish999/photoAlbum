package com.photoalbum.dodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
public class DoDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoDoApplication.class, args);
	}

}
