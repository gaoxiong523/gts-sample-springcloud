package com.gaoxiong.seata.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName AccountFeignClient
 * @Description TODO
 * @date 2019/9/25 16:53
 */
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/debit")
    Boolean debit ( @RequestParam(value = "userId") String userId,
                    @RequestParam(value = "money") BigDecimal money );
}
