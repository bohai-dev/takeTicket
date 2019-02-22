package com.example.takeTicket.controller;

import com.example.takeTicket.domain.AdminUser;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.AdminUserService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cxy on 2018/11/6
 */
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    AdminUserService userService;



    @RequestMapping("/login")
    public ResponseBody<Shop> login(@RequestBody AdminUser adminUser) throws CouponException {

        ResponseBody<Shop>  responseBody=new ResponseBody<>();
        Shop shop=userService.login(adminUser);

        responseBody.setData(shop);
        return  responseBody;
    }
    
    @RequestMapping("/helpWordPath")
    public ResponseBody<String> helpWordPath() throws CouponException {

        String helpPath = "http://test";
        ResponseBody<String>  responseBody=new ResponseBody<>();
        responseBody.setData(helpPath);

        
        return  responseBody;
    }



}
