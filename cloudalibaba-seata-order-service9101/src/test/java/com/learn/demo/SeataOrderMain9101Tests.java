package com.learn.demo;

import com.learn.demo.order.entity.Order;
import com.learn.demo.order.dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
@Slf4j
class SeataOrderMain9101Tests {


    @Resource
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
    }


    @Test
    public void testInsertOrder(){
        Order order = new Order();
        order.setUserId(1);
        order.setProductId(1);
        order.setCount(1);
        order.setMoney(new BigDecimal("100"));
        order.setStatus(0);
        order.setDeleted(0);
        orderMapper.insertOrder(order);
        log.info("创建成功：{}", order);
    }

    @Test
    public void testRemoveOrder(){
        Order order = new Order();
        order.setId(2);
        log.info("删除成功：{}", order);
    }
}
