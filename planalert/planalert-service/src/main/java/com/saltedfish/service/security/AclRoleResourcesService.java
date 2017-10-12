package com.saltedfish.service.security;


import com.saltedfish.entity.AclRoleResources;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclRoleResourcesService {
    /**
     *  根据 roleIds 查询权限集合
     */
    String selectResourceIdsByRoleIds(String roleIds);
}
