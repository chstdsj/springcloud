package com.jyr.api.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyr.api.pojo.User;
import com.jyr.base.ResponseBase;


/**
 * 
 * @author Administrator
 *
 */
public interface IMemberServer {
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("getMember")
	public User getMember(@RequestParam("name") String name);
	
	@RequestMapping("getUserInfo")
	public ResponseBase getUserInfo();

}
