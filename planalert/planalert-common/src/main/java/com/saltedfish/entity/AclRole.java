package com.saltedfish.entity;


public class AclRole extends BaseEntity {
    public AclRole(){}
    public AclRole(String roleName,String pronoun){
        this.roleName = roleName;
        this.pronoun = pronoun;
    }

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色代名词
     */
    private String pronoun;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }
}
