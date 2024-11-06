package com.urekaRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UrekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrekaRegistryApplication.class, args);
	}

}
