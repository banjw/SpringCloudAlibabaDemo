package com.learn.demo.account.service;

import com.learn.demo.account.entity.Account;
import com.learn.demo.account.entity.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <p>
 * 账户库中的账户表 服务类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
public interface AccountService{
    CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
