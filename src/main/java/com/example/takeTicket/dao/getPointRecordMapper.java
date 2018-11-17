package com.example.takeTicket.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.GetPointRecord;

public interface getPointRecordMapper {
    int insert(GetPointRecord record);

    int insertSelective(GetPointRecord record);

    @Select("select * from GET_POINT_RECORD where CUST_ID = #{custId} and SHOP_ID = #{shopId} and CHILD_ID = #{childId} and RECORD_FLG = 0")
    GetPointRecord checkPointInfo(@Param("custId") BigDecimal custId,@Param("shopId") String shopId,@Param("childId") BigDecimal childId);
    
    @Select("select count(*) as num from GET_POINT_RECORD where CUST_ID = #{custId} and SHOP_ID = #{shopId}")
    int selectPointNum(@Param("custId") BigDecimal custId,@Param("shopId") String shopId);

}