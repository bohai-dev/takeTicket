package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustShareInfo;
import com.example.takeTicket.domain.Shop;

public interface CustShareInfoMapper {
    int insert(CustShareInfo record);

    int insertSelective(CustShareInfo record);
    
    @Select("select distinct B.* from CUST_SHARE_INFO A, SHOP B where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID ")
    List<Shop> getCustShareList(@Param("custId")BigDecimal custId);
}