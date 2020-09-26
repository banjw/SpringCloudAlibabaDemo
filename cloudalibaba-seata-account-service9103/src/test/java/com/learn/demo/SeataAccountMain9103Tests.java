package com.learn.demo;

import com.learn.demo.account.entity.Account;
import com.learn.demo.account.service.AccountService;
import com.learn.demo.generator.AccountGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@SpringBootTest
@Slf4j
public class SeataAccountMain9103Tests {
    @Resource
    private AccountGenerator accountGenerator;
    @Resource
    private AccountService accountService;
    @Test
    public void testAccountGenerator(){
        accountGenerator.generateTable("t_account");
    }

    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setUserId(1);
        account.setTotal(new BigDecimal("100"));
        account.setUsed(new BigDecimal("1"));
        account.setResidue(new BigDecimal("99"));
        account.setDeleted(0);
        boolean save = accountService.save(account);
        log.info("保存结果：{}", save);
    }
}
