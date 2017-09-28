package com.saltedfish.enums;

/**
 * Created by xiongjun on 2017/8/25.
 */
public enum  ResultEnums {

    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0, "成功"),
    fail(1,"请求失败")
    ;


    private Integer code ;

    private String msg;

    ResultEnums (Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
