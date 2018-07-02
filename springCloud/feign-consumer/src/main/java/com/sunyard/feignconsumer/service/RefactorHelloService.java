package com.sunyard.feignconsumer.service;

import com.sunyard.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hello-service")
public interface RefactorHelloService extends HelloService {
}
