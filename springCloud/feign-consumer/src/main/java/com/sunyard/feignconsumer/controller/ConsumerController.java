package com.sunyard.feignconsumer.controller;

import com.sunyard.feignconsumer.service.HelloService;
import com.sunyard.feignconsumer.service.RefactorHelloService;
import com.sunyard.helloservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("弟弟")).append("\n");
        sb.append(helloService.hello("妹妹",20)).append("\n");
        sb.append(helloService.hello(new User("哥哥",24))).append("\n");
        return sb.toString();
    }
    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("didi")).append("\n");
        sb.append(refactorHelloService.hello("meimei",20)).append("\n");
        sb.append(refactorHelloService.hello(new com.sunyard.dao.User("gege",24))).append("\n");
        return sb.toString();
    }
}
