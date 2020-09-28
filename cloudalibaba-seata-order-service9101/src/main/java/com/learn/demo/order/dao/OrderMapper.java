package com.learn.demo.order.dao;

import com.learn.demo.order.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单库的订单表 Mapper 接口
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
public interface OrderMapper {
    void insertOrder(Order order);
    void updateOrder(@Param("id") Integer id);
}
