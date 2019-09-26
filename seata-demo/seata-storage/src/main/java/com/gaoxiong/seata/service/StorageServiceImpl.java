package com.gaoxiong.seata.service;

import com.gaoxiong.seata.pojo.Storage;
import com.gaoxiong.seata.repository.StorageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void deduct ( String commodityCode, int count ) throws Exception {
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
}
