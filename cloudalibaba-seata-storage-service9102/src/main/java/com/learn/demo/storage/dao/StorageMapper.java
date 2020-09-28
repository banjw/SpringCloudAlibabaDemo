package com.learn.demo.storage.dao;

import com.learn.demo.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 库存库中的库存表 Mapper 接口
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Mapper
public interface StorageMapper {
    Storage queryStorageByProductId(@Param("productId") Integer productId);

    void updateStorage(@Param("id") Integer id, @Param("used") Integer used, @Param("residue") Integer residue);
}
