package com.learn.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("nacos-payment-provider")
public interface FeignPaymentService {

    @GetMapping("/nacos/get/payment/{id}")
    String getPayment(@PathVariable("id") String id);
}
