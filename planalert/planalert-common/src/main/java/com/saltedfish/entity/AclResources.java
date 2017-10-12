package com.saltedfish.entity;


public class AclResources extends BaseEntity {
    public AclResources(){}

    /**
     * 资源地址
     * 可以是一个模块的请求地址,或者是一个按钮的请求地址
     */
    private String url;

    /**
     * 资源类型
     * 初期计划可以是 请求类型 模块 等等,统一定义为资源
     * 使用  AclResourceTypeEnum   赋值
     */
    private String type;

    /**
     * 资源名称
     * 资源的中文名,为了友好显示
     */
    private String name;
    /**
     * 资源代号
     * 实际上上是模块实体类的名字全小写,如果是按钮,可以是read query等
     */
    private String pronoun;

    /**
     *  上级资源
     */
    private Integer parentId;

    /**
     * 一对一 AclRequestType.id
     */
    private Integer requestTypeId;

    /**
     * 权限
     */
    private String authority;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Integer requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
