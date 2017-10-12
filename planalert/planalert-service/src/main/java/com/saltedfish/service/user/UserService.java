package com.saltedfish.service.user;

import com.saltedfish.entity.User;
import com.saltedfish.service.base.IBaseService;

/**
 * Created by xiongjun on 2017/8/19.
 */
public interface UserService extends IBaseService<User>{

    User getUser(int id);

}
