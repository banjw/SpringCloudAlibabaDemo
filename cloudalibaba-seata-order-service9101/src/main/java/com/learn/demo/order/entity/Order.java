package com.learn.demo.order.entity;

import java.math.BigDecimal;


import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单库的订单表
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 8009644989066029196L;

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 订单状态，0创建中，1完结
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除，1是0否
     */
    private Integer deleted;

}
