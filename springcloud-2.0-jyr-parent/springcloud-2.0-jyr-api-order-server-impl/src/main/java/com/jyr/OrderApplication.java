package com.jyr;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {
	
	public static void main(String[] args) throws Exception {
		//SpringApplication.run(MemberApplication.class, args);
		System.out.println("请输入你的profies名称");
		Scanner scanner = new Scanner(System.in);
		String profile = scanner.nextLine();
		new SpringApplicationBuilder(OrderApplication.class).profiles(profile).run(args);
	}

}
