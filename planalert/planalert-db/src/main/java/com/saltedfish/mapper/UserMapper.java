package com.saltedfish.mapper;

import com.commMapper.MyMapper;
import com.saltedfish.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

/**
 * Created by xiongjun on 2017/8/19.
 */
public interface UserMapper extends MyMapper<User> {
    User getUser(@Param("id")Integer id);
}
