package com.saltedfish.web.handle;

import com.saltedfish.entity.Result;
import com.saltedfish.enums.ResultEnums;
import com.saltedfish.exception.UserException;
import com.saltedfish.util.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiongjun on 2017/8/25.
 */
//@ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法
@ControllerAdvice
public class ExceptionHandle {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    //应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if(e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(ResultEnums.UNKOWN_ERROR.getCode(),ResultEnums.UNKOWN_ERROR.getMsg());
        }
    }
}
