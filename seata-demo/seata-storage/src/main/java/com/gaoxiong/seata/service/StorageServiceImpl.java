package com.gaoxiong.seata.service;

import com.gaoxiong.seata.pojo.Storage;
import com.gaoxiong.seata.repository.StorageRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author gaoxiong
 * @ClassName StorageServiceImpl
 * @Description TODO
 * @date 2019/9/25 11:49
 */
@Service
@Transactional
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void deduct ( String commodityCode, int count ) throws Exception {
        RLock lock = redissonClient.getLock(commodityCode);

        try {

            boolean tryLock = lock.tryLock(50, 15000, TimeUnit.MILLISECONDS);
            if (tryLock) {
                log.info("成功获取到锁{}",lock );
                log.info("进入扣减库存服务,商品编码{},数量{}",commodityCode,count );
                Storage storage = storageRepository.findByCommodityCode(commodityCode);
                int remainCount = storage.getCount() - count;
                if (remainCount < 0) {
                    throw new Exception("库存不足!");
                }
                storage.setCount(remainCount);
                Storage save = storageRepository.save(storage);
                log.info("扣减成功之后的商品库存信息{}",save );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
