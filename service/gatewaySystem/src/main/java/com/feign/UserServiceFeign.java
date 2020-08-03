package com.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by lenovo
 * Date 2020/7/31 10:01
 */
@FeignClient(value = "userSystem")
public interface UserServiceFeign {
}
