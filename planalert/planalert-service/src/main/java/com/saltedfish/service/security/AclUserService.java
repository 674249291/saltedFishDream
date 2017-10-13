package com.saltedfish.service.security;


import com.saltedfish.entity.AclUser;
import com.saltedfish.service.base.IBaseService;

/**
 * Created by Athos on 2016-07-02.
 */
public interface AclUserService extends IBaseService<AclUser> {
    AclUser findAclUserByName(String userName);
}
