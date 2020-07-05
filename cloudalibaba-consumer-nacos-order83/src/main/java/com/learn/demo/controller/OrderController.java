package com.learn.demo.controller;

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

    @GetMapping("/consumer/nacos/get/payment/{id}")
    public String getPayment(@PathVariable("id") String id){
        String result = restTemplate.getForObject(serverUrl + "/nacos/get/payment/" + id, String.class);
        log.info("consumer result:"+result);
        return result;
    }
}
