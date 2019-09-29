package com.gaoxoing.storage.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gaoxiong
 * @ClassName StorageFeignService
 * @Description TODO
 * @date 2019/9/29 14:39
 */
@FeignClient(name = "storage-service")
public interface StorageFeignService {


    @RequestMapping(value = "/deduct", method = RequestMethod.GET, produces = "application/json")
    public String deduct( @RequestParam("commodityCode") String commodityCode,@RequestParam("count") int count) throws Exception;
}
