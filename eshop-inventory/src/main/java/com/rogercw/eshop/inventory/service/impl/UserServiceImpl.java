package com.rogercw.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rogercw.eshop.inventory.entity.UserEntity;
import com.rogercw.eshop.inventory.mapper.UserMapper;
import com.rogercw.eshop.inventory.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 从数据库获取用户信息
     * @param userId
     * @return
     */
    @Override
    public UserEntity getUserInfo(Long userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        return userEntity;
    }

    /**
     * 从缓存中获取用户信息
     * @return
     */
    @Override
    public UserEntity getCachedInfo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.parseLong("2"));
        userEntity.setAge(24);
        userEntity.setName("lisi");
        userEntity.setSex("男");
        userEntity.setPhone("14576846598");
        String jsonString = JSONArray.toJSONString(userEntity);
        stringRedisTemplate.opsForValue().set("cached_user", jsonString);

        String cachedUser = stringRedisTemplate.opsForValue().get("cached_user");
        JSONObject jsonObject = JSONObject.parseObject(cachedUser);
        UserEntity user = new UserEntity();
        user.setId(jsonObject.getLong("id"));
        user.setName(jsonObject.getString("name"));
        user.setAge(jsonObject.getInteger("age"));
        user.setSex(jsonObject.getString("sex"));
        user.setPhone(jsonObject.getString("phone"));
        return user;
    }
}
