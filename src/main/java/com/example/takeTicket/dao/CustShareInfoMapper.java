package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustShareInfo;
import com.example.takeTicket.vo.Shop3Vo;

public interface CustShareInfoMapper {
    int insert(CustShareInfo record);

    int insertSelective(CustShareInfo record);
    
 //   @Select("select distinct B.* from CUST_SHARE_INFO A, SHOP B where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID ")
    @Select("select distinct B.*,nvl(C.POINT_NUMBER - C.POINT_SUB,0) as Point_Avail from CUST_SHARE_INFO A, SHOP B,CUST_POINT_RECORD C where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID and A.CUST_ID = C.CUST_ID (+) and A.SHOP_ID = C.SHOP_ID (+)")
    List<Shop3Vo> getCustShareList(@Param("custId")BigDecimal custId);
}