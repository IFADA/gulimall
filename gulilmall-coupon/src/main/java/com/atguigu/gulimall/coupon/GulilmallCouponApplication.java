package com.atguigu.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.coupon.dao")
@EnableDiscoveryClient
public class GulilmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulilmallCouponApplication.class, args);
    }

}
