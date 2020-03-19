package com.rogercw.eshop.inventory.request;

/**
 * @author rogercw
 * @date 2019-12-16
 */
public interface Request {

    /**
     * 处理请求的方法
     */
    void process();

    /**
     * 获取产品Id
     * @return
     */
    Long getProductId();

    /**
     * 是否强制刷新
     * @return
     */
    Boolean isForceReferensh();
}
