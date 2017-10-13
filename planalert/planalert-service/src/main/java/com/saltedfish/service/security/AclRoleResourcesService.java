package com.saltedfish.service.security;

import com.saltedfish.entity.AclRoleResources;
import com.saltedfish.service.base.IBaseService;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclRoleResourcesService extends IBaseService<AclRoleResources> {
    /**
     *  根据 roleIds 查询权限集合
     */
    String selectResourceIdsByRoleIds(String roleIds);
}
