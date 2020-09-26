package com.learn.demo.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author banjiawei
 * @description
 * @date 2020/09/26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;
    public CommonResult(Integer code, String msg){
        this(code, msg, null);
    }
}
