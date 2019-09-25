package com.gaoxiong.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gaoxiong
 * @ClassName BusinessApp
 * @Description TODO
 * @date 2019/9/25 11:24
 */
@SpringCloudApplication
@EnableFeignClients
public class BusinessApp {
    public static void main ( String[] args ) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
