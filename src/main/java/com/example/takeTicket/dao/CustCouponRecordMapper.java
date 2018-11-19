package com.example.takeTicket.dao;

import com.example.takeTicket.domain.CustCouponRecord;

public interface CustCouponRecordMapper {
    int deleteByPrimaryKey(String custCouponId);

    int insert(CustCouponRecord record);

    int insertSelective(CustCouponRecord record);

    CustCouponRecord selectByPrimaryKey(String custCouponId);

    int updateByPrimaryKeySelective(CustCouponRecord record);

    int updateByPrimaryKey(CustCouponRecord record);
}