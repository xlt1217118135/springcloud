package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lenovo
 * Date 2020/7/30 18:05
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringServiceStart {

    private final static Logger log = LoggerFactory.getLogger(SpringServiceStart.class);

    public static void main(String[] args){

        SpringApplication.run(SpringServiceStart.class, args);

        log.info("********************************注册中心启动*************************************************");
    }
}
