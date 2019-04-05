package com.jyr.api.server.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jyr.api.pojo.User;
import com.jyr.api.server.IMemberServer;
import com.jyr.base.BaseApiService;
import com.jyr.base.ResponseBase;


@RestController
public class MemberServer extends BaseApiService implements IMemberServer {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("getMember")
	public User getMember(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name+" 端口号："+port);
		user.setAge(20);
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping("getUserInfo")
	public ResponseBase getUserInfo() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return setResultSuccess("订单服务调用会员服务成功");
	};

}
