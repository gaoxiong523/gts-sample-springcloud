package com.taobao.txc.sample.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDao {

    @Update("update storage_tbl set count = count - #{count} where commodity_code = #{commodityCode}")
    void deduct(@Param("commodityCode") String commodityCode, @Param("count") int count);
}
