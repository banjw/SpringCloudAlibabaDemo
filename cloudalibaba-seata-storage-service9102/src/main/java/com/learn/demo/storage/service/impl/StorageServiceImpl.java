package com.learn.demo.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.demo.storage.entity.CommonResult;
import com.learn.demo.storage.entity.Storage;
import com.learn.demo.storage.mapper.StorageMapper;
import com.learn.demo.storage.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Override
    public CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        //查询
        Storage queryStorage = new Storage();
        queryStorage.setProductId(productId);
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(queryStorage);
        queryStorage = this.getOne(queryWrapper);

        Integer residue = queryStorage.getResidue();
        if(count > residue){
            return new CommonResult(-1, "大于产品库存，扣减失败");
        }
        log.info("扣减之前库存为：{}", residue);
        residue -= count;
        queryStorage.setResidue(residue);
        log.info("扣减之后库存为：{}", residue);

        Integer used = queryStorage.getUsed();
        used += count;
        queryStorage.setUsed(used);

        //更新操作
        boolean flag = this.saveOrUpdate(queryStorage);
        if(flag){
            return new CommonResult(1, "扣减成功");
        }else {
            return new CommonResult(-1, "扣减失败");

        }
    }
}
