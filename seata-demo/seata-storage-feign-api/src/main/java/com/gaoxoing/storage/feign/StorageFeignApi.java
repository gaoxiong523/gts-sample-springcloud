package com.gaoxoing.storage.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gaoxiong
 * @ClassName StorageFeignApi
 * @Description TODO
 * @date 2019/9/29 14:36
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class StorageFeignApi {
    public static void main ( String[] args ) {
        SpringApplication.run(StorageFeignApi.class, args);
    }

}
