package com.saltedfish.entity;

import com.saltedfish.annotation.MapperClass;
import com.saltedfish.mapper.AclRequestTypeMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Athos on 2016-07-06.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclrequesttype")
@MapperClass(AclRequestTypeMapper.class)
public class AclRequestType extends BaseEntity {
    public AclRequestType(){}
    public AclRequestType(String name,String pronoun){
        this.name = name;
        this.pronoun = pronoun;
    }
    /**
     * 请求类型名
     * 例如 搜索,查看,新增,删除 等等
     */
    @Column
    private String name;
    /**
     * 请求类型 代号
     * 例如: search,lookover,add,delete 等等
     */
    @Column
    private String pronoun;

}
