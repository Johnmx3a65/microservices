package org.parovsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsMicroServiceApplication.class, args);
	}

}
