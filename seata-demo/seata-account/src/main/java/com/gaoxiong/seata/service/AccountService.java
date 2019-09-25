package com.gaoxiong.seata.service;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName AccountService
 * @Description TODO
 * @date 2019/9/25 16:43
 */
public interface AccountService {

    /**
     * 账户扣余额
     * @param userId 用户id
     * @param num 钱数
     */
    void debit ( String userId, BigDecimal num );
}
