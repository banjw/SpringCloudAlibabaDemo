package com.learn.demo;

import com.learn.demo.generator.OrderGenerator;
import com.learn.demo.order.entity.Order;
import com.learn.demo.order.mapper.OrderMapper;
import com.learn.demo.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
@Slf4j
@EnableFeignClients
class SeataOrderMain9101Tests {

    @Autowired
    private OrderGenerator orderGenerator;

//    @Autowired
//    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testOrderGenerator(){
        orderGenerator.generateTable("t_order");
    }

    @Test
    public void testInsertOrder(){
        Order order = new Order();
        //设置了自增，自定义没有用，@TableId(value = "id", type = IdType.AUTO)
        order.setId(1);
        order.setUserId(1);
        order.setProductId(1);
        order.setCount(1);
        order.setMoney(new BigDecimal("100"));
        order.setStatus(0);
        order.setDeleted(0);
        orderMapper.insert(order);
        log.info("创建成功：{}", order);
    }

    @Test
    public void testRemoveOrder(){
        Order order = new Order();
        order.setId(2);
//        orderService.removeById(order.getId());
        log.info("删除成功：{}", order);
    }
}
