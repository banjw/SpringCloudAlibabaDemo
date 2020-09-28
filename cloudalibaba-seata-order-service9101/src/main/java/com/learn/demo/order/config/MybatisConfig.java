package com.learn.demo.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@Configuration
@MapperScan("com.learn.demo.order.dao")
public class MybatisConfig {
}
