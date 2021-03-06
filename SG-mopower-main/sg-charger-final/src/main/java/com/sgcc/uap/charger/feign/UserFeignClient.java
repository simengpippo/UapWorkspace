package com.sgcc.uap.charger.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Feign实现需要定义接口！
@FeignClient(name="SGMoPower-sub-st",fallback=HystrixClientFallback.class) //,fallback=HystrixClientFallback.class
public interface UserFeignClient {
	@RequestMapping(value = "/station/idname")
	public Map queryIdName();
}
