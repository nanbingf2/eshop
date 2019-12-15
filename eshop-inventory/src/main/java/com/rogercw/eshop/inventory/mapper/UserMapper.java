package com.rogercw.eshop.inventory.mapper;

import com.rogercw.eshop.inventory.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UserEntity> {
}
