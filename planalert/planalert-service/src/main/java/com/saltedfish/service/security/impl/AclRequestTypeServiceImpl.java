package com.saltedfish.service.security.impl;


import com.saltedfish.annotation.MapperClass;
import com.saltedfish.entity.AclRequestType;
import com.saltedfish.mapper.AclRequestTypeMapper;
import com.saltedfish.service.base.impl.BaseServiceImpl;
import com.saltedfish.service.security.AclRequestTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by Athos on 2016-07-12.
 */
@Service
@MapperClass(AclRequestTypeMapper.class)
public class AclRequestTypeServiceImpl extends BaseServiceImpl<AclRequestType> implements AclRequestTypeService {

    protected AclRequestTypeMapper getMapper(){
        return super.getMapper(AclRequestType.class);
    }

    @Override
    public String findPronounStrByRequestTypeIds(String requestTypeIds) {
        return this.getMapper().findPronounStrByRequestTypeIds(requestTypeIds);
    }

    @Override
    public int selectCountByNeId(AclRequestType aclRequestType){
        return 0;
    }
}
