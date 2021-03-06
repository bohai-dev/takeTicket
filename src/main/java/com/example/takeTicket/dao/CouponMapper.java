package com.example.takeTicket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.Coupon;

public interface CouponMapper {
    int deleteByPrimaryKey(String couponId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(String couponId);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
    
    @Select("select * from COUPON where SHOP_ID = #{shopId} and IS_DELETE = '0' order by EXCHANGE_TIMES,COUPON_TYPE")
    List<Coupon> getShopIdfindCoupon(@Param("shopId")String shopId);
}