package com.saltedfish.mapper;

import com.saltedfish.entity.AclUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Athos on 2016-06-30.
 */
public interface AclUserMapper extends Mapper<AclUser> {
    @Select("SELECT * FROM tbl_sysmgr_acluser WHERE user_name = #{userName}")
    AclUser findAclUserByName(String userName);
}
