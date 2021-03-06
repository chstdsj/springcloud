package com.jyr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private DiscoveryClient discoveryClient;

	@GetMapping("getOrder")
	public String getOrder() {
		
//		discoveryClient.get
		//使用应用名称去注册中心找对应服务的调用地址
		//rest使用应用名称去请求服务，依赖ribbon,RestTemplate必须加上@LoadBalanced
		String url = "http://member-provider/getMember";
		//String url = "http://localhost:9003/getMember";
		String result = restTemplate.getForObject(url, String.class);	
		System.out.println( "member服务返回结果："+result);
		return "订单服务返回结果："+result;
	}
	
	@RequestMapping("/")
	public String index() {
		return "我是订单服务 "+port;
	}
	
}
