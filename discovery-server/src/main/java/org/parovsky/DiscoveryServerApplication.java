package org.parovsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(org.parovsky.DiscoveryServerApplication.class, args);
	}
}
