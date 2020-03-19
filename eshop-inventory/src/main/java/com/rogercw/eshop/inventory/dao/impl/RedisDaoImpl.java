package com.rogercw.eshop.inventory.dao.impl;

import com.rogercw.eshop.inventory.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author rogercw
 * @date 2019-12-16
 */
@Component
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }
}
