package com.saltedfish.entity;


public class AclUser extends BaseEntity {
    public AclUser(){}

    public AclUser(String userName,String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
    /**
     * 角色 json 格式  或逗号间隔 或转换为数组
     */
    private String roleIds;

    private String roleNames;

    /**
     * 转换为数据 瞬时
     */
    private String [] rolesesArray;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String[] getRolesesArray() {
        return rolesesArray;
    }

    public void setRolesesArray(String[] rolesesArray) {
        this.rolesesArray = rolesesArray;
    }
}
