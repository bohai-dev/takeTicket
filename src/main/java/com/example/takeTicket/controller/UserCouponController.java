package com.example.takeTicket.controller;

import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.UserCouponService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;
import com.example.takeTicket.vo.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cxy on 2018/11/19
 */
@RestController
@RequestMapping("/coupon")
public class UserCouponController {

    @Autowired
    UserCouponService userCouponService;

    /**
     * 销毁优惠券
     * @param userCouponId
     * @return
     * @throws CouponException
     */
    @RequestMapping(value = "/destroy",method =RequestMethod.GET)
    public ResponseHeader destroyCoupon(@RequestParam("userCouponId")String userCouponId) throws CouponException {
        ResponseHeader responseHeader=new ResponseHeader();
        userCouponService.destroyCoupon(userCouponId);

        return responseHeader;
    }

    /**
     * 查询优惠券信息
     * @param userCouponId
     * @return
     * @throws CouponException
     */
    @RequestMapping(value = "/selectbyid",method = RequestMethod.GET)
    public ResponseBody<UserCoupon> selectById(@RequestParam("userCouponId")String userCouponId)  throws CouponException{
        ResponseBody<UserCoupon> responseBody=new ResponseBody<>();
        UserCoupon userCoupon=userCouponService.selectById(userCouponId);
        responseBody.setData(userCoupon);

        return responseBody;

    }

}
