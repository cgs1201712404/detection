package com.hptpd.sewageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 19:42
 * \* Description:
 * \
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SewageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SewageServiceApplication.class, args);
    }

}

