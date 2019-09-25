package com.gaoxiong.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author gaoxiong
 * @ClassName StorageApp
 * @Description TODO
 * @date 2019/9/25 11:22
 */
@SpringCloudApplication
public class StorageApp {
    public static void main ( String[] args ) {
        SpringApplication.run(StorageApp.class, args);
    }
}
