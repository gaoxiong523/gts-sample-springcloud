package com.gaoxoing.storage.feign.controller;

import com.gaoxoing.storage.feign.api.StorageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName StorageApiController
 * @Description TODO
 * @date 2019/9/29 14:40
 */
@RestController
public class StorageApiController {

    @Autowired
    private StorageFeignService storageFeignService;

    @GetMapping("/deduct")
    public String deduct ( @RequestParam String commodityCode, @RequestParam int count ) {
        try {
            storageFeignService.deduct(commodityCode, count);
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
        return "SUCCESS";
    }

}
