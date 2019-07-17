package com.taobao.txc.sample.controller;

import com.taobao.txc.sample.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.taobao.txc.sample.service.BusinessService.SUCCESS;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */

@RestController
public class BusinessController {

    private static final String USER_ID = "U100000";
    private static final String COMMODITY_CODE = "C100000";
    private static final int ORDER_COUNT = 30;
    private final RestTemplate restTemplate;
    @Autowired
    private BusinessService businessService;

    public BusinessController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @RequestMapping(value = "/purchase/transactional", method = RequestMethod.GET, produces = "application/json")
    public String purchaseTransactional(Boolean rollback) {
        try {

            businessService.purchase(USER_ID, COMMODITY_CODE, ORDER_COUNT,
                rollback == null ? false : rollback.booleanValue());
        } catch (Exception exx) {
            return "error:" + exx.getMessage();
        }
        return SUCCESS;
    }
}
