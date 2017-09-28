package com.saltedfish.exception;

import com.saltedfish.enums.ResultEnums;

/**
 * Created by xiongjun on 2017/8/25.
 */
public class UserException extends RuntimeException {

    private Integer code;

    public UserException (ResultEnums resultEnums){

        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
