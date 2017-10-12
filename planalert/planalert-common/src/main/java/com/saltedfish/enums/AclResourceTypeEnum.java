package com.saltedfish.enums;


public enum AclResourceTypeEnum {

    MODULE("M"),    //模块

    SUBMODULE("S"),//子模块

    REQUEST("R");//请求,CRUD


    String value;

    AclResourceTypeEnum() {
    }

    AclResourceTypeEnum(String value) {
        this.value = value;
    }
}
