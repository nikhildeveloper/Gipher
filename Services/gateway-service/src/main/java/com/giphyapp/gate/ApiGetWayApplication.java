package com.giphyapp.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ApiGetWayApplication {

	public static void main(String[] args) {
	SpringApplication.run(ApiGetWayApplication.class, args);
	System.out.println("Api-Gateway is running...");
	
	}
}
