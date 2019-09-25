package com.gaoxiong.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gaoxiong
 * @ClassName OrderApp
 * @Description TODO
 * @date 2019/9/25 11:24
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.gaoxiong.seata.feign")
public class OrderApp {
    public static void main ( String[] args ) {
        SpringApplication.run(OrderApp.class, args);
    }
}
