package com.learn.demo.account.entity;

import java.math.BigDecimal;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账户库中的账户表
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;

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
