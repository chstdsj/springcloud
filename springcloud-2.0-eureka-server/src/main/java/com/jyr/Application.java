package com.jyr;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		System.out.println("请输入你的profies名称");
		Scanner scanner = new Scanner(System.in);
		String profile = scanner.nextLine();
		new SpringApplicationBuilder(Application.class).profiles(profile).run(args);
		
		
	}

}
