package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by lenovo
 * Date 2020/7/31 9:51
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients // 启用 Feign
public class getwayServiceStart {

    public static void main(String[] args){
        SpringApplication.run(getwayServiceStart.class, args);
    }
}
