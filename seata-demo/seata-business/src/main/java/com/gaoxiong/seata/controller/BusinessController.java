package com.gaoxiong.seata.controller;

import com.gaoxiong.seata.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName BusinessController
 * @Description TODO
 * @date 2019/9/26 9:32
 */
@RestController
@Slf4j
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @RequestMapping(value = "/purchase/commit", produces = "application/json")
    public String purchaseCommit(String userId,String commodityCode,int orderCount) {
        try {
            businessService.purchase(userId, commodityCode, orderCount);
        } catch (Exception exx) {
            log.info(exx.getMessage() );
            return exx.getMessage();
        }
        return "全局事务提交";
    }

    /**
     * 购买下单，模拟全局事务回滚
     * 账户或库存不足
     *
     * @return
     */
    @RequestMapping("/purchase/rollback")
    public String purchaseRollback(String userId,String commodityCode,int orderCount) {
        try {
            businessService.purchase(userId, commodityCode, orderCount);
        } catch (Exception exx) {

            return exx.getMessage();
        }
        return "全局事务提交";
    }
}
