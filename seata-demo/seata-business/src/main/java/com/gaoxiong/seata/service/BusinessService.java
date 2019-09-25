package com.gaoxiong.seata.service;

/**
 * @author gaoxiong
 * @ClassName BusinessService
 * @Description TODO
 * @date 2019/9/25 17:01
 */
public interface BusinessService {
    /**
     * 下单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void purchase(String userId, String commodityCode, int orderCount);
}
