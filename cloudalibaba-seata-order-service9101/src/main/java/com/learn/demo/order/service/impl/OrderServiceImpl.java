package com.learn.demo.order.service.impl;

import com.learn.demo.order.entity.Order;
import com.learn.demo.order.dao.OrderMapper;
import com.learn.demo.order.service.AccountService;
import com.learn.demo.order.service.OrderService;
import com.learn.demo.order.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 订单库的订单表 服务实现类
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Resource
    private OrderMapper orderMapper;

    @Override
    @GlobalTransactional(name = "test_seata_globalT_transactional", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("==================创建订单start");
        orderMapper.insertOrder(order);

        log.info("==================订单微服务调用库存微服务做扣减库存操作start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("==================订单微服务调用库存微服务做扣减库存操作end");

        log.info("==================订单微服务调用账户微服务做扣减余额操作start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("==================订单微服务调用账户微服务做扣减余额操作end");

        log.info("==================修改订单状态start");
        orderMapper.updateOrder(order.getId());
        log.info("==================修改订单状态end");

        log.info("==================创建订单end");
    }
}
