package com.jyr.api.fallback;

import com.jyr.api.feign.IMemberServerFeign;
import com.jyr.api.pojo.User;
import com.jyr.base.BaseApiService;
import com.jyr.base.ResponseBase;


public class MemberFallback extends BaseApiService implements IMemberServerFeign {

	@Override
	public User getMember(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBase getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
