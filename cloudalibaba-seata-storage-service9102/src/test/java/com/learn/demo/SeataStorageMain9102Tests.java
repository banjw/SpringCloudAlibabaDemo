package com.learn.demo;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.learn.demo.generator.StorageGenerator;
import com.learn.demo.storage.entity.Storage;
import com.learn.demo.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@SpringBootTest
@Slf4j
public class SeataStorageMain9102Tests {

    @Autowired
    private StorageGenerator storageGenerator;

    @Autowired
    private StorageService storageService;

    @Test
    public void testStorageGenerator(){
        storageGenerator.generateTable("t_storage");
    }

    @Test
    public void testSaveStorage(){
        Storage storage = new Storage();
        storage.setProductId(1);
        storage.setTotal(10);
        storage.setUsed(1);
        storage.setResidue(9);
        storage.setDelete(0);
        storageService.save(storage);
        log.info("添加成功：{}", storage);
    }

    /**
     * #逻辑删除，使用的是删除方法，实际是更新操作
     * mybatis-plus:
     *   global-config:
     *     db-config:
     *       logic-delete-field: delete  # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)com.learn.demo.storage.entity.Storage#delete字段
     *       logic-delete-value: 1 # 逻辑已删除值(默认为 1)
     *       logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
     *    会自动拼接查询或者更新时 UPDATE t_storage SET is_delete=1 WHERE id=? AND is_delete=0
     */
    @Test
    public void testRemoveStorage(){
        Storage storage = new Storage();
        storage.setId(2);
        //UPDATE t_storage SET is_delete=1 WHERE id=? AND is_delete=0
        storageService.removeById(storage.getId());
        log.info("删除成功：{}", storage);
    }

    @Test
    public void testUpdateStorage(){

        Storage updateStorage = new Storage();
        updateStorage.setUsed(2);
        updateStorage.setResidue(8);

        Storage targetStorage= new Storage();
        targetStorage.setId(3);
        targetStorage.setDelete(0);


        UpdateWrapper<Storage> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setEntity(targetStorage);
        //UPDATE t_storage SET used=?, residue=?, update_time=? WHERE id=? AND is_delete=?
        boolean update = storageService.update(updateStorage, updateWrapper);
        log.info("更新结果：{}", update);
    }

}
