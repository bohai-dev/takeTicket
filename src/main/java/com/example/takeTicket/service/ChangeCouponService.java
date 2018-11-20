package com.example.takeTicket.service;

import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponException;

/**
 * Cteated by caoxx on 2018/11/6
 */
public interface ChangeCouponService {

	/**
     * 客户兑换优惠券
     * @param shop
     * @return
     */
	CustCouponRecord custChangeCoupon(String custId,String shopId,String couponId) throws CouponException;


}
