package com.sgcc.uap.charger.feign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient{

	@Override
	public Map queryIdName() {
		// TODO Auto-generated method stub
		return new HashMap();
		
	}
}
