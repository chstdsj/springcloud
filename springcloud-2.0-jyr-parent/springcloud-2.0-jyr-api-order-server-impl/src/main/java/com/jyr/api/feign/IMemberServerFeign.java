package com.jyr.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import com.jyr.api.fallback.MemberFallback;
import com.jyr.api.server.IMemberServer;

//@FeignClient("member-provider")
@FeignClient(value = "member-provider",fallback = MemberFallback.class)
public interface IMemberServerFeign extends IMemberServer {
	
	

}
