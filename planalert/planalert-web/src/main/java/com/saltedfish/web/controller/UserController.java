package com.saltedfish.web.controller;


import com.saltedfish.entity.Result;
import com.saltedfish.entity.User;
import com.saltedfish.mapper.UserMapper;
import com.saltedfish.service.user.UserService;
import com.saltedfish.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiongjun on 2017/8/19.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public Result<User> getUser(){
        User user = userService.getUser(1);
        return ResultUtil.success(user);
    }

    @RequestMapping("find")
    public Result<User> findUser(){
        User user = userService.getEntityById(User.class,1);
        return ResultUtil.success(user);
    }
}
