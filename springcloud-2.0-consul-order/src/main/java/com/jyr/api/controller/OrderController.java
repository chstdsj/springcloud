package com.jyr.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("getOrder")
	public String getOrder() {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("consul-member");
		for (int i = 0; i < instances.size(); i++) {
			ServiceInstance serviceInstance = instances.get(i);
			URI uri = serviceInstance.getUri();
			System.out.println(uri.toString());
		}
		//使用应用名称去注册中心找对应服务的调用地址
		//rest使用应用名称去请求服务，依赖ribbon,RestTemplate必须加上@LoadBalanced
		String url = "http://consul-member/getMember";
		//String url = "http://localhost:9003/getMember";
		String result = restTemplate.getForObject(url, String.class);	
		System.out.println( "member服务返回结果："+result);
		return "订单服务返回结果："+result;
	}
	
}
