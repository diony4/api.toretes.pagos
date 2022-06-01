package com.pagosToretes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication(scanBasePackages = { "com.pagosToretes" })
public class PagosToretesApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {


	
	public static void main(String[] args ){
		SpringApplication.run(PagosToretesApplication.class, args);
		
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PagosToretesApplication.class);
	}

}
