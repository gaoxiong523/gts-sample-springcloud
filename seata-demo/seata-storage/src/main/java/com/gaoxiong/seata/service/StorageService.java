package com.gaoxiong.seata.service;

/**
 * @author gaoxiong
 * @ClassName StorageService
 * @Description TODO
 * @date 2019/9/25 11:44
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param commodityCode 商品编码
     * @param count
     */
    void deduct ( String commodityCode, int count );
}
