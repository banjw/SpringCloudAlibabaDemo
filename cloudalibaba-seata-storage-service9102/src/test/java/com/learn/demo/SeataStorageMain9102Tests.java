package com.learn.demo;

import com.learn.demo.storage.dao.StorageMapper;
import com.learn.demo.storage.entity.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@SpringBootTest
@Slf4j
public class SeataStorageMain9102Tests {


    @Resource
    private StorageMapper storageMapper;


    @Test
    public void testQueryStorage(){
        Storage storage = new Storage();
        storage.setProductId(1);
        storage = storageMapper.queryStorageByProductId(storage.getProductId());
        log.info("查询成功：{}", storage);
    }

}
