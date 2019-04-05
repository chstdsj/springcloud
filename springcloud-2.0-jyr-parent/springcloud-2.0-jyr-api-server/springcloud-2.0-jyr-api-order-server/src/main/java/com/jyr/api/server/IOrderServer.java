package com.jyr.api.server;

import org.springframework.web.bind.annotation.RequestMapping;

import com.jyr.base.ResponseBase;

public interface IOrderServer {

	//订单服务调用会员服务接口信息
	@RequestMapping("orderToMember")
	public String orderToMember(String name);
	
	//订单服务调用会员服务接口
	@RequestMapping("orderToMemberUserInfo")
	public ResponseBase orderToMemberUserInfo();
	
	//订单服务接口
	@RequestMapping("orderInfo")
	public ResponseBase orderInfo();
	
}
