package com.example.takeTicket.controller;


import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.CustUserService;
import com.example.takeTicket.vo.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class CustUserController {

    @Autowired
    CustUserService userService;


    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ResponseBody<String> login(@RequestParam("code") String code) throws CouponException {
        ResponseBody<String> responseBody=new ResponseBody<>();
        String userId=userService.login(code);

        responseBody.setData(userId);

        return  responseBody;
    }


}
