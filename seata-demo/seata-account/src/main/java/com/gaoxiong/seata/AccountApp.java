package com.gaoxiong.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author gaoxiong
 * @ClassName AccountApp
 * @Description TODO
 * @date 2019/9/25 11:25
 */
@SpringCloudApplication
public class AccountApp {
    public static void main ( String[] args ) {
        SpringApplication.run(AccountApp.class, args);
    }
}
