package com.affiliate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.affiliate.app"})
public class AffiliateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AffiliateAppApplication.class, args);
	}

}
