package com.gaoxiong.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gaoxiong
 * @ClassName StorageFeignClient
 * @Description TODO
 * @date 2019/9/25 17:04
 */
@FeignClient(name = "storage-service")
public interface StorageFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") Integer count);

}
