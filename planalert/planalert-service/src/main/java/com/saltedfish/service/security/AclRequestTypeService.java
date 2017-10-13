package com.saltedfish.service.security;


import com.saltedfish.entity.AclRequestType;
import com.saltedfish.service.base.IBaseService;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclRequestTypeService extends IBaseService<AclRequestType> {
    String findPronounStrByRequestTypeIds(String requestTypeIds);
    int selectCountByNeId(AclRequestType aclRequestType);
}
