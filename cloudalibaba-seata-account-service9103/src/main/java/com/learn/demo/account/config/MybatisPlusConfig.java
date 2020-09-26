package com.learn.demo.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@Configuration
@MapperScan("com.learn.demo.account.mapper")
public class MybatisPlusConfig {
}
