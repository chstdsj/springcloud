package com.jyr.api.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("member-provider")
public interface IOrderServer {

	@GetMapping("getMember")
	public String getMember(); 
	
}
