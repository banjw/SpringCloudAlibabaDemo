package com.learn.demo.order.service;

import com.learn.demo.order.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@FeignClient(value = "seata-account-service")
@Repository
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
