package com.example.takeTicket.controller;

import com.example.takeTicket.domain.AdminUser;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.AdminUserService;
import com.example.takeTicket.vo.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseHeader login(@RequestBody AdminUser adminUser) throws CouponException {

        ResponseHeader responseHeader=new ResponseHeader();
        AdminUser resultUser=userService.selectUser(adminUser);

       // returnBody.setData(resultUser);
        if (resultUser==null){
            throw new CouponException(CouponErrorConstant.ADMIN_LOGIN_ERROR);
        }


        return  responseHeader;
    }



}
