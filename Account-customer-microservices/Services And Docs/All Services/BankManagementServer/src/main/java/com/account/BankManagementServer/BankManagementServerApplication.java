package com.account.BankManagementServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagementServerApplication.class, args);
	}

}
