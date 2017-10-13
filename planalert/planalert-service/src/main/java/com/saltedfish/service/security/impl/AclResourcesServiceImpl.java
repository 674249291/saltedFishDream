package com.saltedfish.service.security.impl;


import com.saltedfish.annotation.MapperClass;
import com.saltedfish.entity.AclResources;
import com.saltedfish.mapper.AclResourcesMapper;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.security.AclResourcesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Athos on 2016-07-12.
 */
@Service
@MapperClass(AclResourcesMapper.class)
public class AclResourcesServiceImpl extends BaseServiceImpl<AclResources> implements AclResourcesService {

    protected AclResourcesMapper getMapper(){
        return super.getMapper(AclResources.class);
    }

    @Override
    public List<AclResources> selectAclResourcesTypeOfRequest(){
       return getMapper().selectAclResourcesTypeOfRequest();
    }

    @Override
    public List<AclResources> selectAclResourcesByResourceIds(String resourceIds) {
        return getMapper().selectAclResourcesByResourceIds(resourceIds.split(","));
}
}
