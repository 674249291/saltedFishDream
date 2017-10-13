package com.saltedfish.service.security.impl;


import com.saltedfish.annotation.MapperClass;
import com.saltedfish.entity.AclRole;
import com.saltedfish.mapper.AclRoleMapper;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.security.AclRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service
@MapperClass(AclRoleMapper.class)
public class AclRoleServiceImpl extends BaseServiceImpl<AclRole> implements AclRoleService {

    protected AclRoleMapper getMapper(){
        return super.getMapper(AclRole.class);
    }

    @Override
    public String findAclRolesByAclUserRoleIds(String roleIds) {
        return this.getMapper().findAclRolesByAclUserRoleIds(roleIds);
    }
}