package com.gaoxiong.seata.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName AccountFeignClient
 * @Description TODO
 * @date 2019/9/25 16:53
 */
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @RequestMapping("/debit")
    Boolean debit ( String userId, BigDecimal money );
}
