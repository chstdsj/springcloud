package com.jyr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private IOrderServer orderServer;
	
	@GetMapping("getOrder")
	public String getOrder() {
		return orderServer.getMember();
	}
	
}
