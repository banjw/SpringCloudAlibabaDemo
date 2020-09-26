package com.learn.demo.order.service;

import com.learn.demo.order.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@FeignClient(value = "seata-storage-service")
@Repository
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
