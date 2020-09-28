package com.learn.demo.storage.service.impl;

import com.learn.demo.storage.entity.CommonResult;
import com.learn.demo.storage.entity.Storage;
import com.learn.demo.storage.dao.StorageMapper;
import com.learn.demo.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * <p>
 * 库存库中的库存表 服务实现类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        //查询
        Storage storage = storageMapper.queryStorageByProductId(productId);

        Integer residue = storage.getResidue();
        if(count > residue){
            return new CommonResult(-1, "大于产品库存，扣减失败");
        }
        log.info("扣减之前库存为：{}", residue);
        residue -= count;
        log.info("扣减之后库存为：{}", residue);

        Integer used = storage.getUsed();
        used += count;

        //更新操作
        storageMapper.updateStorage(storage.getId(), used, residue);
        return new CommonResult(1, "扣减成功");
    }
}
