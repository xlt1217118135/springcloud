package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by lenovo
 * Date 2020/7/27 14:03
 */
@SpringBootApplication
@EnableEurekaClient
public class UserServiceStart {

    public static void main(String[] args){

        SpringApplication.run(UserServiceStart.class, args);
    }
}
