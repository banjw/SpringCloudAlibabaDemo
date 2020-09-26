package com.learn.demo.storage.controller;


import com.learn.demo.storage.entity.CommonResult;
import com.learn.demo.storage.service.StorageService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 库存库中的库存表 前端控制器
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count){
        Assert.notNull(productId, "productId不能为空");
        Assert.notNull(count, "count不能为空");
        return storageService.decrease(productId, count);
    }
}

