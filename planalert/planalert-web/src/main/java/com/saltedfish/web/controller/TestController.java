package com.saltedfish.web.controller;

import com.saltedfish.entity.AclRequestType;
import com.saltedfish.entity.AclResources;
import com.saltedfish.entity.AclRoleResources;
import com.saltedfish.service.security.AclRequestTypeService;
import com.saltedfish.service.security.AclResourcesService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Athos on 2016-07-14.
 */
@RestController
@RequestMapping("/food")
public class TestController {

    @Resource
    private AclRequestTypeService aclRequestTypeService;

    @PreAuthorize("hasAuthority('AUTH_FOOD_QUERY')")
    @RequestMapping(value = "/queryFood",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void foods(){
        System.out.println(aclRequestTypeService.getEntityById(AclRequestType.class,1));
        System.out.println("读取食物.....");
    }

    @PreAuthorize("hasAuthority('AUTH_FOOD_ADD')")
    @RequestMapping("/addFood")
    public  void add(){
        System.out.println("新增食物");
    }

    @RequestMapping("/selectCountByNeId")
    public  void selectCountByNeId(){
    }
}
