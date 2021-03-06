package com.saltedfish.service.security;


import com.saltedfish.entity.AclRole;
import com.saltedfish.service.base.IBaseService;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclRoleService extends IBaseService<AclRole> {
    /**
     *  根据AclUser的属性值查询返回逗号间隔的角色集字符串
     */
    String findAclRolesByAclUserRoleIds(String roleIds);
}