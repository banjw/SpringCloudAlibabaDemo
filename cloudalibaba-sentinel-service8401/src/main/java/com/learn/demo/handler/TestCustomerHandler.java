package com.learn.demo.handler;


import com.alibaba.csp.sentinel.slots.block.BlockException;

public class TestCustomerHandler {

    public static String testHandler1(BlockException exception){
        return "自定义处理方法1";
    }
    public static String testHandler2(BlockException exception){
        return "自定义处理方法2";
    }
}
