package com.saltedfish.util;

import com.saltedfish.entity.Result;
import com.saltedfish.enums.ResultEnums;

/**
 * Created by xiongjun on 2017/8/25.
 */
public class ResultUtil {

    public  static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMsg(ResultEnums.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success (){
        return success(null);
    }

    public static Result error (Integer code , String msg){
        Result result = new Result();
        result.setCode(ResultEnums.fail.getCode());
        result.setMsg(ResultEnums.fail.getMsg());
        return result;
    }
}
