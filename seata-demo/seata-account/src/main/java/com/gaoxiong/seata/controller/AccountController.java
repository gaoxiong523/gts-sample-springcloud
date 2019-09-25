package com.gaoxiong.seata.controller;

import com.gaoxiong.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName AccountController
 * @Description TODO
 * @date 2019/9/25 16:51
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/debit")
    public Boolean debit(String userId, BigDecimal money) {
        accountService.debit(userId, money);

        return true;
    }
}
