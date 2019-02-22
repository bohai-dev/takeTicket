package com.example.takeTicket.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.takeTicket.domain.CustNshareInfo;

public interface CustNshareInfoMapper {
    int insert(CustNshareInfo record);

    int insertSelective(CustNshareInfo record);
    
    @Update("update CUST_NSHARE_INFO set CONTROL_FLG = '1' where SHARE_STYLE = #{shareStyle}")
    void updShareStatue(@Param("shareStyle")String shareStyle);
    
    @Select("select * from CUST_NSHARE_INFO where CUST_ID = #{custId} and SHOP_ID = #{shopId} and SHARE_STYLE = #{shareStyle} and CONTROL_FLG is null and rownum = 1")
    CustNshareInfo checkShareStatue(@Param("custId")String custId,@Param("shopId")String shopId,@Param("shareStyle")String shareStyle);
}