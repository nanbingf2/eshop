package com.rogercw.eshop.inventory.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rogercw
 * @date 2019-12-18
 * 请求内存队列：对JUC中阻塞队列对分装
 */
public class RequestQueue {

    private List<ArrayBlockingQueue> blockingQueues = new ArrayList<>();

    private Map<Integer, Boolean> flagMap = new ConcurrentHashMap<>();

    private RequestQueue() {
    }


    /**
     * 静态内部类：完成实例对创建
     */
    public static class Singleton{

        private static RequestQueue requestQueue;

        static {
            requestQueue = new RequestQueue();
        }

        public static RequestQueue getInstance(){
            return requestQueue;
        }

    }

    /**
     * jvm的机制去保证多线程并发安全
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     * @return
     */
    public static RequestQueue getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 网内存队列里添加队列
     * @param arrayBlockingQueue
     */
    public void addQueue(ArrayBlockingQueue arrayBlockingQueue){
        blockingQueues.add(arrayBlockingQueue);
    }

    /**
     * 获取内存队列的大小
     * @return
     */
    public Integer getSize(){
        return blockingQueues.size();
    }

    public ArrayBlockingQueue<Request> getQueue(int index) {
        return blockingQueues.get(index);
    }

    public Map<Integer, Boolean> getFlagMap() {
        return flagMap;
    }
}
