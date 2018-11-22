package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.vo.UserCouponAllInfoVo;

public interface CustCouponRecordMapper {
    int deleteByPrimaryKey(String custCouponId);

    int insert(CustCouponRecord record);

    int insertSelective(CustCouponRecord record);

    CustCouponRecord selectByPrimaryKey(String custCouponId);

    int updateByPrimaryKeySelective(CustCouponRecord record);

    int updateByPrimaryKey(CustCouponRecord record);
    
    @Select("select CUST_COUPON_ID_SEQ.nextval from dual")
    int selCustCouponIDSeq();
    
    //@Select("select * from CUST_COUPON_RECORD where CUST_ID = #{custId} and COUPON_STATE = #{couponStatus}")
    @Select("select A.*,B.COUPON_TYPE as COUPON_TYPE,B.COUPON_VALUE as COUPON_VALUE,B.BACKUP_COLUMN1 as BACKUP_COLUMN1,B.BACKUP_COLUMN2 as BACKUP_COLUMN2,B.IS_DELETE as IS_DELETE,B.EXCHANGE_TIMES as EXCHANGE_TIMES  from CUST_COUPON_RECORD A,COUPON B where CUST_ID = #{custId} and COUPON_STATE = #{couponStatus} and A.COUPON_ID = B.COUPON_ID")
    List<UserCouponAllInfoVo> selectCouponListByCust(@Param("custId")String custId,@Param("couponStatus")BigDecimal couponStatus);
    
    
}