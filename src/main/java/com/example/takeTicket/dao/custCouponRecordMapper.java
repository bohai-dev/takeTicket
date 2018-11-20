package com.example.takeTicket.dao;

import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustCouponRecord;

public interface custCouponRecordMapper {
    int deleteByPrimaryKey(String custCouponId);

    int insert(CustCouponRecord record);

    int insertSelective(CustCouponRecord record);

    CustCouponRecord selectByPrimaryKey(String custCouponId);

    int updateByPrimaryKeySelective(CustCouponRecord record);

    int updateByPrimaryKey(CustCouponRecord record);
    
    @Select("select CUST_COUPON_ID_SEQ.nextval from dual")
    int selCustCouponIDSeq();
    
}