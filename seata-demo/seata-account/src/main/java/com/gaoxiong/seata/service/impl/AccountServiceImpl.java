package com.gaoxiong.seata.service.impl;

import com.gaoxiong.seata.pojo.Account;
import com.gaoxiong.seata.repository.AccountRepository;
import com.gaoxiong.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @date 2019/9/25 16:45
 */
@Service
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void debit ( String userId, BigDecimal num ) {
        Account account = accountRepository.findByUserId(userId);
        account.setMoney(new BigDecimal(account.getMoney()).subtract(num).intValue());
        accountRepository.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
