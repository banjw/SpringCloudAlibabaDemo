package com.learn.demo.account.dao;

import com.learn.demo.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <p>
 * 账户库中的账户表 Mapper 接口
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Mapper
public interface AccountMapper{

    Account queryAccountByUserId(@RequestParam("userId") Integer userId);

    void updateAccount(@RequestParam("id") Integer id, @RequestParam("used") BigDecimal used, @RequestParam("residue") BigDecimal residue);
}
