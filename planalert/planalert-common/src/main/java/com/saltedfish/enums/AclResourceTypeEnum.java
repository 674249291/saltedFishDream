package com.saltedfish.enums;


public enum AclResourceTypeEnum {

    /**
     * 模块
     */
    MODULE("M"),

    /**
     * 子模块
     */
    SUBMODULE("S"),

    /**
     * 请求,CRUD
     */
    REQUEST("R");


    String value;

    AclResourceTypeEnum() {
    }

    AclResourceTypeEnum(String value) {
        this.value = value;
    }
}
