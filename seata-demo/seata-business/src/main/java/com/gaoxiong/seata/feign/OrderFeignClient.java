package com.gaoxiong.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gaoxiong
 * @ClassName OrderFeignClient
 * @Description TODO
 * @date 2019/9/25 17:03
 */
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @GetMapping("/create")
    void create(@RequestParam("userId") String userId,
                @RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") Integer count);

}
