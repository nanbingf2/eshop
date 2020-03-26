package com.rogercw.eureka.client.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author rogercw
 * @date 2020-03-21
 */
@FeignClient(value = "say-hello-service", fallback = SayHelloFallback.class)
public interface SayHelloFeignClient {

    @RequestMapping(value = "sayHello", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);
}
