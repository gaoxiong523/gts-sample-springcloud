package com.taobao.txc.sample.service;

import com.taobao.txc.common.TxcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    @Autowired
    private StorageDao storageDao;

    public void deduct(String commodityCode, int count) {
        String xid = TxcContext.getCurrentXid();
        LOGGER.info("deduct storage balance in transaction: " + xid);

        storageDao.deduct(commodityCode, count);
    }
}
