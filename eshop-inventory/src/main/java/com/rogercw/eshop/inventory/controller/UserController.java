package com.rogercw.eshop.inventory.controller;

import com.rogercw.eshop.inventory.entity.UserEntity;
import com.rogercw.eshop.inventory.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUserInfo")
    public UserEntity getUserInfo(Long userId){
        UserEntity userEntity = userService.getUserInfo(userId);
        return userEntity;
    }

    @GetMapping("getCachedUser")
    public UserEntity getCachedUser(){
        return userService.getCachedInfo();
    }

}
