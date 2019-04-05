package com.jyr.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

	@Value("${server.port}")
	String port;
	
	@GetMapping("getMember")
	public String getMember() {
		System.out.println(port);
		return "我是会员服务，this is member "+port;
	}
	
}
