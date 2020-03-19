package com.rogercw.eshop.inventory.thread;

import com.rogercw.eshop.inventory.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author rogercw
 * @date 2019-12-18
 * 请求处理线程：又一个自己监控的内存队列
 */
public class RequestProcessThread implements Callable {

    //监控的内存队列
    private ArrayBlockingQueue<Request> arrayBlockingQueue;

    public RequestProcessThread(ArrayBlockingQueue<Request> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }


    @Override
    public Object call() throws Exception {
        return null;
    }
}
