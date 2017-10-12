package com.saltedfish.entity;


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
    private String name;
    /**
     * 请求类型 代号
     * 例如: search,lookover,add,delete 等等
     */
    private String pronoun;

}
