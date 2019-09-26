package com.gaoxiong.seata.service.impl;

import com.gaoxiong.seata.feign.OrderFeignClient;
import com.gaoxiong.seata.feign.StorageFeignClient;
import com.gaoxiong.seata.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName BusinessServiceImpl
 * @Description TODO
 * @date 2019/9/25 17:02
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private StorageFeignClient storageFeignClient;

    @Override
    @GlobalTransactional
    public void purchase ( String userId, String commodityCode, int orderCount ) throws Exception {
        orderFeignClient.create(userId, commodityCode, orderCount);
        storageFeignClient.deduct(commodityCode,orderCount );
    }
}
