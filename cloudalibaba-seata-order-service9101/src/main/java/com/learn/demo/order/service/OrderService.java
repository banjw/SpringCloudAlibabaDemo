package com.learn.demo.order.service;

import com.learn.demo.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单库的订单表 服务类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
public interface OrderService extends IService<Order> {

    void createOrder(Order order);
}
