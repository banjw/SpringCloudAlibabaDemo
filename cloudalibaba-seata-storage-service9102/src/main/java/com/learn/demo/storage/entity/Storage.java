package com.learn.demo.storage.entity;


import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 库存库中的库存表
 * </p>
 *
 * @author banjiawei
 * @since 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Storage implements Serializable {

    private static final long serialVersionUID = 1993501278039215343L;

    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

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
