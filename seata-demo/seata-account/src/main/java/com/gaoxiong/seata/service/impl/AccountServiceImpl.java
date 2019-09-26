package com.gaoxiong.seata.service.impl;

import com.gaoxiong.seata.pojo.Account;
import com.gaoxiong.seata.repository.AccountRepository;
import com.gaoxiong.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void debit ( String userId, BigDecimal num ) {
        //设置锁定资源名称
        RLock lock = redissonClient.getLock(userId);

        try {
            //尝试获取锁
            log.info("尝试获取锁");
            lock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            log.info("用户id {},进入方法,进行扣减余额{}操作", userId, num);
            Account account = accountRepository.findByUserId(userId);
            account.setMoney(new BigDecimal(account.getMoney()).subtract(num).intValue());
            Account save = accountRepository.save(account);
            log.info("扣减余额成功,扣减之后的账户{}", save);

            if (ERROR_USER_ID.equals(userId)) {
                throw new RuntimeException("account branch exception");
            }
        } catch (InterruptedException e) {
            log.error("获取锁失败{}", e);
            e.printStackTrace();
        } finally {
            lock.unlock();
            log.info("释放锁成功");
        }
    }
}
