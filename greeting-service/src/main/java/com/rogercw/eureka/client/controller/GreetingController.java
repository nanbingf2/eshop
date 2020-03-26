package com.rogercw.eureka.client.controller;

import com.rogercw.eureka.client.feignClient.SayHelloFeignClient;
import com.rogercw.eureka.client.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rogercw
 * @date 2020-03-21
 */
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private SayHelloFeignClient feignClient;

    @GetMapping("greeting")
    public String greeting(String name) {
        return greetingService.greeting(name);
    }

    @GetMapping("greetingByFeign")
    public String greetingByFeign(String name) {
        return feignClient.sayHello(name);
    }
}
