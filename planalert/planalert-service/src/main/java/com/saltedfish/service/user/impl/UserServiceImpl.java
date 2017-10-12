package com.saltedfish.service.user.impl;

import com.saltedfish.dao.user.UserDao;
import com.saltedfish.entity.User;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.user.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiongjun on 2017/8/19.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }


}
