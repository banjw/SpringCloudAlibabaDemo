package com.learn.demo.order.service;

import com.learn.demo.order.entity.Order;

/**
 * <p>
 * 订单库的订单表 服务类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
public interface OrderService {

    void createOrder(Order order);
}
