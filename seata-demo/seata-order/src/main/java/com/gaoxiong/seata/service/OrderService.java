package com.gaoxiong.seata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName OrderService
 * @Description TODO
 * @date 2019/9/25 16:31
 */
public interface OrderService {

    /**
     * 创建订单,
     * @param userId 用户id
     * @param commodityCode 商品编码
     * @param count 商品数量
     */
    void create ( String userId, String commodityCode, Integer count );
}
