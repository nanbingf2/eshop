package com.rogercw.eshop.inventory.service;

import com.rogercw.eshop.inventory.entity.UserEntity;

public interface IUserService {

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserEntity getUserInfo(Long userId);

    /**
     * 通过缓存获取
     * @return
     */
    UserEntity getCachedInfo();

}
