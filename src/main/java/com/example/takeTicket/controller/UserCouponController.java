package com.example.takeTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.UserCouponService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;
import com.example.takeTicket.vo.UserCoupon;

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
    
    /**
     * 查询客户优惠券一览
     * @param userCouponId
     * @return
     * @throws CouponException
     */
    @RequestMapping(value = "/selectCouponListByCust",method = RequestMethod.GET)
    public ResponseBody<List<CustCouponRecord>> selectCouponListByCust(@RequestParam("custId")String custId,@RequestParam("couponStatus")String couponStatus)  throws CouponException{
        ResponseBody<List<CustCouponRecord>> responseBody=new ResponseBody<>();
       
        responseBody.setData(userCouponService.selectCouponListByCust(custId, couponStatus));

        return responseBody;

    }

}
