package com.taobao.txc.sample.controller;

import com.taobao.txc.sample.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account")
    public Boolean debit(String userId, int money) {
        accountService.reduce(userId, money);
        return true;
    }
}