package com.jyr;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MemberApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MemberApplication.class, args);
		
		System.out.println("请输入member的profile");
		Scanner scanner = new Scanner(System.in);
		String profile = scanner.nextLine();
		
		new SpringApplicationBuilder(MemberApplication.class)//
			.profiles(profile)//
			.run(args);
	}

}
