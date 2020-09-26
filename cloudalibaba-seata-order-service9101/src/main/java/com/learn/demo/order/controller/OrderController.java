package com.learn.demo.order.controller;


import com.learn.demo.order.entity.CommonResult;
import com.learn.demo.order.entity.Order;
import com.learn.demo.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 订单库的订单表 前端控制器
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult CreateOrder(@RequestBody Order order){
        try {
            orderService.createOrder(order);
            return new CommonResult(1, "下单成功");
        } catch (Exception e){
            e.printStackTrace();
            return new CommonResult(-1, "下单失败");
        }
    }
}

