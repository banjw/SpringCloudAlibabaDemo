package com.learn.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.demo.handler.TestCustomerHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testA")
    public String testA(){
        return "TestA================================serverPort:"+serverPort;
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB================================serverPort:"+serverPort;
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "testHotkeyBlockHandler")
    public String testHotkey(String p1, String p2){
        return "testHotkey================================serverPort:"+serverPort;
    }

    public String testHotkeyBlockHandler(String p1, String p2, BlockException exception){
        return "testHotkeyBlockHandler================"+serverPort;//默认返回时Blocked by Sentinel (flow limiting)
    }

    @GetMapping("/testCustomerHandler")
    @SentinelResource(value = "testCustomerHandler", blockHandlerClass = TestCustomerHandler.class, blockHandler = "testHandler2")
    public String testCustomerHandler(){
        return "testCustomerHandler=================="+serverPort;
    }
}
