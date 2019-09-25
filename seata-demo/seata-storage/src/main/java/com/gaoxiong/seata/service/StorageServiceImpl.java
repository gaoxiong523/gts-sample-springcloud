package com.gaoxiong.seata.service;

import com.gaoxiong.seata.pojo.Storage;
import com.gaoxiong.seata.repository.StorageRepository;
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
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public void deduct ( String commodityCode, int count ) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        storage.setCount(storage.getCount() - count);
        storageRepository.save(storage);
    }
}
