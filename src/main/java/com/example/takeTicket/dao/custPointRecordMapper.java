package com.example.takeTicket.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.takeTicket.domain.CustPointRecord;

public interface custPointRecordMapper {
    int insert(CustPointRecord record);

    int insertSelective(CustPointRecord record);
    
    @Select("select * from CUST_POINT_RECORD where CUST_ID = #{custId} and SHOP_ID = #{shopId}")
    CustPointRecord getPoint(@Param("custId")String custId,@Param("shopId")String shopId);
    
    @Update("update CUST_POINT_RECORD set POINT_NUMBER = POINT_NUMBER + #{pointNum},UPDATE_TIME = sysdate where CUST_ID = #{custId} and SHOP_ID = #{shopId}")
    int addPoint(@Param("custId")String custId,@Param("shopId")String shopId,@Param("pointNum")BigDecimal pointNum);
    
    @Update("update CUST_POINT_RECORD set POINT_SUB = POINT_SUB + #{subPointNum} ,UPDATE_TIME = sysdate where CUST_ID = #{custId} and SHOP_ID = #{shopId}")
    int subPoint(@Param("custId")String custId,@Param("shopId")String shopId,@Param("subPointNum")BigDecimal subPointNum);
    
}