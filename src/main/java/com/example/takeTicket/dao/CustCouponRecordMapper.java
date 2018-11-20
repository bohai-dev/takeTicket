package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustCouponRecord;

public interface CustCouponRecordMapper {
    int deleteByPrimaryKey(String custCouponId);

    int insert(CustCouponRecord record);

    int insertSelective(CustCouponRecord record);

    CustCouponRecord selectByPrimaryKey(String custCouponId);

    int updateByPrimaryKeySelective(CustCouponRecord record);

    int updateByPrimaryKey(CustCouponRecord record);
    
    @Select("select CUST_COUPON_ID_SEQ.nextval from dual")
    int selCustCouponIDSeq();
    
    @Select("select * from CUST_COUPON_RECORD where CUST_ID = #{custId} and COUPON_STATE = #{couponStatus}")
    List<CustCouponRecord> selectCouponListByCust(@Param("custId")String custId,@Param("couponStatus")BigDecimal couponStatus);
    
    
}