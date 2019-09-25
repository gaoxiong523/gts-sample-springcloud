package com.gaoxiong.seata.repository;

import com.gaoxiong.seata.pojo.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StorageRepository extends JpaRepository<Storage, Integer>, JpaSpecificationExecutor<Storage> {

    /**
     * 根据商品编码找到商品
     * @param commodityCode
     * @return
     */
    Storage findByCommodityCode(String commodityCode);
}