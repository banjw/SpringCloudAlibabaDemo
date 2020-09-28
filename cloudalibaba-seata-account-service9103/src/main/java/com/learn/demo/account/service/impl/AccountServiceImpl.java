package com.learn.demo.account.service.impl;

import com.learn.demo.account.dao.AccountMapper;
import com.learn.demo.account.entity.Account;
import com.learn.demo.account.entity.CommonResult;
import com.learn.demo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

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
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public CommonResult decrease(Integer userId, BigDecimal money) {

        Account account = accountMapper.queryAccountByUserId(userId);

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
        //模拟超时，全局事务回滚
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountMapper.updateAccount(account.getId(), used, residue);
        return new CommonResult(1, "扣减成功");
    }
}
