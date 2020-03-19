package com.rogercw.eshop.inventory.thread;

import com.rogercw.eshop.inventory.request.RequestQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rogercw
 * @date 2019-12-18
 * 请求处理线程池：单例模式
 */
public class RequestProcessThreadPool {


    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private RequestProcessThreadPool() {

        RequestQueue requestQueue = RequestQueue.getInstance();
        /**
         * 创建10个队列
         */
        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100);
            requestQueue.addQueue(arrayBlockingQueue);
            threadPool.submit(new RequestProcessThread(arrayBlockingQueue));
        }
    }

    /**
     * 静态内部类：负责创建实例对象
     */
    public static class Singleton{

        private static RequestProcessThreadPool requestProcessThreadPool;

        static {
            requestProcessThreadPool = new RequestProcessThreadPool();
        }

        public static RequestProcessThreadPool getInstance(){
            return requestProcessThreadPool;
        }
    }

    public static RequestProcessThreadPool getInstance(){
        return Singleton.getInstance();
    }

    public static RequestProcessThreadPool init(){
        return getInstance();
    }
}
