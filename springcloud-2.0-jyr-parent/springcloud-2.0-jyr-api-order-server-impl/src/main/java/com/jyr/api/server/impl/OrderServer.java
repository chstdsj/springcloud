package com.jyr.api.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jyr.api.feign.IMemberServerFeign;
import com.jyr.api.pojo.User;
import com.jyr.api.server.IOrderServer;
import com.jyr.base.BaseApiService;
import com.jyr.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderServer extends BaseApiService implements IOrderServer {
	
	@Autowired
	private IMemberServerFeign memberFeign;

	@RequestMapping("orderToMember")
	public String orderToMember(@RequestParam("name") String name) {
		User user = memberFeign.getMember(name);
		return user==null?"没有找到":user.toString();
	}

	//没有解决雪崩效应
	@RequestMapping("orderToMemberUserInfo")
	public ResponseBase orderToMemberUserInfo() {
		return memberFeign.getUserInfo();
	}
	
	//解决雪崩效应
	//fallbackMethod作用：服务降级
	//@HystrixCommand默认开启纯种隔离方式，服务降级、服务熔断
	@HystrixCommand(fallbackMethod="orderToMemberUserInfoHystrixfallback")
	@RequestMapping("orderToMemberUserInfoHystrix")
	public ResponseBase orderToMemberUserInfoHystrix() {
		System.out.println("orderToMemberUserInfoHystrix线程池名称："+Thread.currentThread().getName());
		return memberFeign.getUserInfo();
	}
	
	public ResponseBase orderToMemberUserInfoHystrixfallback() {
		return setResultSuccess("解决雪崩效应，返回一个友好提示");
	}

	//订单服务接口
	@RequestMapping("orderInfo")
	public ResponseBase orderInfo() {
		System.out.println("orderInfo线程池名称："+Thread.currentThread().getName());
		return setResultSuccess();
	}

	//Hystrix有两种方式配置保护服务，通过注解和接口形式
	
}
