package com.rogercw.eureka.client.feignClient;

import org.springframework.stereotype.Component;

/**
 * @author rogercw
 * @date 2020-03-21
 */
@Component
public class SayHelloFallback implements SayHelloFeignClient {

    @Override
    public String sayHello(String name) {
        return "null---from hystrix";
    }
}
