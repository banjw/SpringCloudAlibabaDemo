package com.learn.demo.account.controller;


import com.learn.demo.account.entity.CommonResult;
import com.learn.demo.account.service.AccountService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 账户库中的账户表 前端控制器
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money){
        Assert.notNull(userId, "userId不能为空");
        Assert.notNull(money, "money不能为空");
        //模拟超时，全局事务回滚
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accountService.decrease(userId, money);
    }
}

