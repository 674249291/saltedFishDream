package com.saltedfish.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiongjun on 2017/8/21.
 */
@Controller
public class Test {

    @RequestMapping("test")
    public String test(){

        return "index";
    }

}
