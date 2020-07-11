package com.learn.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.demo.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private FeignPaymentService feignPaymentService;

    @GetMapping("/consumer/nacos/get/payment/{id}")
    public String getPayment(@PathVariable("id") String id){
        String result = restTemplate.getForObject(serverUrl + "/nacos/get/payment/" + id, String.class);
        log.info("consumer result:"+result);
        return result;
    }

    @GetMapping("/consumer/sentinel/feign/get/payment/{id}")
    public String getFeignPayment(@PathVariable("id") String id){
        String result = feignPaymentService.getPayment(id);
        log.info("open feign, consumer result:"+result);
        return result;
    }


    @GetMapping("/comsumer/sentinel/feign/testSentinel/{id}")
    @SentinelResource(value = "testSentinel", fallback = "testFallback", blockHandler = "testBlockHandler")
    public String testSentinel(String p1, String p2, @PathVariable("id") String id){
        String result = feignPaymentService.getPayment(id);
        if("a".equals(p1)){
            throw new IllegalArgumentException("人为抛出差数不合法异常");
        }
        if("b".equals(p2)){
            throw new NullPointerException("人为抛出空指针异常");
        }
        return result;
    }

    public String testFallback(String p1, String p2, @PathVariable("id") String id){
        return "fallback方法被调用,serverPort:"+serverPort;
    }

    public String testBlockHandler(String p1, String p2, @PathVariable("id") String id, BlockException exception){
        return "testBlockHandler,serverPort:"+serverPort;
    }
}
