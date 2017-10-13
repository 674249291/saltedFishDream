package com.saltedfish.service.security;



import com.saltedfish.entity.AclResources;
import com.saltedfish.service.base.IBaseService;

import java.util.List;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclResourcesService extends IBaseService<AclResources> {
    /**
     *  查询所有类型是 请求 的资源
     *  返回包括{ROLE_MODULE_CRUD}
     *  为了方法级权限控制
     */
    List<AclResources> selectAclResourcesTypeOfRequest();


    /**
     * 根据 resourceIds 逗号间隔字符串 查询资源
     */
    List<AclResources> selectAclResourcesByResourceIds(String resourceIds);
}
