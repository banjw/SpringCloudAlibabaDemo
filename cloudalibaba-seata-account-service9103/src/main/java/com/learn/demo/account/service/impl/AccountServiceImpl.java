package com.learn.demo.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.demo.account.entity.Account;
import com.learn.demo.account.entity.CommonResult;
import com.learn.demo.account.mapper.AccountMapper;
import com.learn.demo.account.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 账户库中的账户表 服务实现类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public CommonResult decrease(Integer userId, BigDecimal money) {

        Account account = new Account();
        account.setUserId(userId);
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(account);
        account = this.getOne(queryWrapper);

        BigDecimal residue = account.getResidue();
        if(money.compareTo(residue) > 0){
            return new CommonResult(-1, "扣除金额大于账户剩余金额，扣除操作失败");
        }
        log.info("扣减之前余额为：{}", residue);
        residue = residue.subtract(money);
        account.setResidue(residue);
        log.info("扣减之后余额为：{}", residue);

        BigDecimal used = account.getUsed();
        used = used.add(money);
        account.setUsed(used);

        boolean flag = this.saveOrUpdate(account);
        if(flag){
            return new CommonResult(1, "扣减成功");
        }else {
            return new CommonResult(-1, "扣减失败");

        }
    }
}
