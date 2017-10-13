package com.saltedfish.service.security.impl;


import com.saltedfish.annotation.MapperClass;
import com.saltedfish.entity.AclRoleResources;
import com.saltedfish.mapper.AclRoleResourcesMapper;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.security.AclRoleResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Athos on 2016-07-12.
 */
@Service
@MapperClass(AclRoleResourcesMapper.class)
public class AclRoleResourcesServiceImpl extends BaseServiceImpl<AclRoleResources> implements AclRoleResourcesService {

    protected AclRoleResourcesMapper getMapper(){
        return super.getMapper(AclRoleResources.class);
    }

    @Override
    public String selectResourceIdsByRoleIds(String roleIds) {
        String resourceIds = this.getMapper().selectResourceIdsByRoleIds(roleIds);
        String [] resourceIdsArray = resourceIds.split(",");
        ArrayList<String> list = new ArrayList<String>();
        for(String resourceId : resourceIdsArray){
            if(!list.contains(resourceId)){
                list.add(resourceId);
            }
        }
        return StringUtils.join(list.toArray(),",");
    }
}
