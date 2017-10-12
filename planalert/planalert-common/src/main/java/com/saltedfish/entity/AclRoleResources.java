package com.saltedfish.entity;



public class AclRoleResources extends BaseEntity {
    public AclRoleResources(){};
    public AclRoleResources(Integer roleId,String resourceIds){
        this.roleId = roleId;
        this.resourceIds = resourceIds;
    }

    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 资源ID,逗号间隔,或者JSON
     */
    private String resourceIds;

    /**
     * 资源名称
     */
    private String resourceNames;



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(String resourceNames) {
        this.resourceNames = resourceNames;
    }
}
