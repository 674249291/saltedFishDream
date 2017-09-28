package com.saltedfish.dao.user.impl;

import com.saltedfish.dao.user.UserDao;
import com.saltedfish.entity.User;
import com.saltedfish.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiongjun on 2017/8/19.
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
