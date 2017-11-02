package com.saltedfish.enums;

/**
 * Created by xiongjun on 2017/8/25.
 */
public enum  ResultEnums {

    /**
     * 未知错误
     */
    UNKOWN_ERROR(-1,"未知错误"),
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 请求失败
     */
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
