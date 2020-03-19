package com.rogercw.eshop.inventory.service;

import com.rogercw.eshop.inventory.request.Request;

/**
 * @author rogercw
 * @date 2019-12-18
 */
public interface RequestAsyncProcessService {

    void process(Request request);
}
