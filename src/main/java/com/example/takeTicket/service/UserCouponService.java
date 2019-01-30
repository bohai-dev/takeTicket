package com.example.takeTicket.service;

import java.util.List;

import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.vo.UserCoupon;
import com.example.takeTicket.vo.UserCouponAllInfoVo;

/**
 * Created by cxy on 2018/11/19
 */
public interface UserCouponService {

    /**
     *  销毁优惠券
      * @param userCouponId
     */
    CustCouponRecord destroyCoupon(String userCouponId) throws CouponException;

    /**
     * 查询优惠券信息
      * @param userCouponId
     * @return
     * @throws CouponException
     */
    UserCoupon selectById(String userCouponId,String shopId) throws CouponException;
    
    /**
     * 查询客户优惠券一览
      * @param userCouponId
     * @return
     * @throws CouponException
     */
    List<UserCouponAllInfoVo> selectCouponListByCust(String custId,String couponStatus) throws CouponException;
}
