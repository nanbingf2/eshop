package com.rogercw.eshop.inventory.service.impl;

import com.rogercw.eshop.inventory.request.Request;
import com.rogercw.eshop.inventory.request.RequestQueue;
import com.rogercw.eshop.inventory.service.RequestAsyncProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author rogercw
 * @date 2019-12-18
 */
@Slf4j
@Service
public class RequestAsyncProcessServiceImpl implements RequestAsyncProcessService {

    @Override
    public void process(Request request) {
        try {
            //根据商品ID做请求的路由：
            ArrayBlockingQueue<Request> arrayBlockingQueue = routeQueue(request.getProductId());
            arrayBlockingQueue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayBlockingQueue<Request> routeQueue(Long productId) {
        RequestQueue requestQueue = RequestQueue.getInstance();
        int h;
        String key = String.valueOf(productId);
        //计算hash值
        int hash = key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        //对hash值取模获取索引
        int index = (requestQueue.getSize() - 1) & hash;
        log.info("路由内存队列，商品id=" + productId + ", 队列索引=" + index);
        return requestQueue.getQueue(index);
    }
}
