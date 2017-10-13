package com.saltedfish.service.security.impl;


import com.saltedfish.annotation.MapperClass;
import com.saltedfish.entity.AclUser;
import com.saltedfish.mapper.AclUserMapper;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.security.AclUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-02.
 */
@Service
@MapperClass(AclUserMapper.class)
public class AclUserServiceImpl extends BaseServiceImpl<AclUser> implements AclUserService {
//    @CountTime
    @Override
    public AclUser findAclUserByName(String userName) {
        return getMapper().findAclUserByName(userName);
    }
    protected AclUserMapper getMapper(){
        return super.getMapper(AclUser.class);
    }
}
