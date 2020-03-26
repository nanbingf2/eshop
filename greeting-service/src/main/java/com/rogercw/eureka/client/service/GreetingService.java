package com.rogercw.eureka.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author rogercw
 * @date 2020-03-21
 */
@Service
public class GreetingService {

    @Autowired
    private RestTemplate restTemplate;

    public String greeting(String name) {
        return restTemplate.getForObject("http://say-hello-service/sayHello?name=" + name, String.class);
    }
}
