package com.jyr.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(TokenFilter.class);
	
	@Override
	public boolean shouldFilter() {//是否要过滤:写逻辑判断
		return true;
	}

	@Override
	public Object run() throws ZuulException {//过滤器的具体逻辑
		//获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取Request
        HttpServletRequest request = ctx.getRequest();
        //获取token，从请求头中获取
        //String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
        //log.info(s);
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
			//不会继续执行... 不会去调用服务接口，网关服务直接响应给客户端
        	ctx.setSendZuulResponse(false);
        	ctx.setResponseBody("userToken is null");
        	ctx.setResponseStatusCode(401);
        	return null;
        	//返回一个错误提示
		}
        //正常执行调用其他服务接口...
        log.info("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {//过滤器的类型
        //pre：请求之前
        //routing：请求之时
        //post： 请求之后
        //error：发送错误调用
		return "pre";
	}

	//过滤器顺序,当一个请求在同一个阶段存在多个过滤器的时候，多个过滤器执行顺序
	@Override
	public int filterOrder() {
		return 0;
	}

}
