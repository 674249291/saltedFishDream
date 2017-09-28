package com.saltedfish.mapper;

import com.saltedfish.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xiongjun on 2017/8/19.
 */
public interface UserMapper {
    User getUser(@Param("id")Integer id);
}
