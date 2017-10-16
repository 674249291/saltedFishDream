package com.saltedfish.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.saltedfish.constant.Constant;
import com.saltedfish.dao.user.UserDao;
import com.saltedfish.entity.Result;
import com.saltedfish.entity.User;
import com.saltedfish.enums.ResultEnums;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.user.UserService;
import com.saltedfish.service.util.JwtUtil;
import com.saltedfish.util.ResultUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiongjun on 2017/8/19.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Autowired
    private JwtUtil jwt;


    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public Result<String> login(User user) {
        try {
            //没有做数据库的处理
            if(!"admin".equals(user.getUsername()) || !"123456".equals(user.getPwd())){
                return ResultUtil.error(ResultEnums.fail.getCode(),"账号或者密码错误");
            }
            String subject = JwtUtil.generalSubject(user);
            String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
            String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
            JSONObject jo = new JSONObject();
            jo.put("token", token);
            jo.put("refreshToken", refreshToken);
            return ResultUtil.success(jo);
        } catch (Exception e) {
            logger.error(e);
            return ResultUtil.error(ResultEnums.UNKOWN_ERROR.getCode(),"未知错误");
        }
    }


}
