package com.jyr;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MemberApplication.class, args);
		
		System.out.println("请输入order的profile");
		Scanner scanner = new Scanner(System.in);
		String profile = scanner.nextLine();
		
		new SpringApplicationBuilder(OrderApplication.class)//
			.profiles(profile)//
			.run(args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
