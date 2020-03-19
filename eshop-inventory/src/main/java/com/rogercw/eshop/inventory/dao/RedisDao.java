package com.rogercw.eshop.inventory.dao;

/**
 * @author rogercw
 * @date 2019-12-16
 */
public interface RedisDao {

    /**
     * 向缓存中设置值
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 从缓存中获取指定值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 删除某个键值对
     * @param key
     */
    void delete(String key);
}
