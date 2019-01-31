package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.CustShareInfo;
import com.example.takeTicket.vo.CustCanExchangeCouponVo;
import com.example.takeTicket.vo.Shop3Vo;

public interface CustShareInfoMapper {
    int insert(CustShareInfo record);

    int insertSelective(CustShareInfo record);
    
 //   @Select("select distinct B.* from CUST_SHARE_INFO A, SHOP B where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID ")
 //   @Select("select distinct B.*,nvl(C.POINT_NUMBER - C.POINT_SUB,0) as Point_Avail from CUST_SHARE_INFO A, SHOP B,CUST_POINT_RECORD C where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID and A.CUST_ID = C.CUST_ID (+) and A.SHOP_ID = C.SHOP_ID (+)")
    @Select("select distinct B.*,nvl(C.POINT_NUMBER - C.POINT_SUB,0) as Point_Avail,(select EXCHANGE_TIMES from COUPON E where A.SHOP_ID = E.SHOP_ID and B.SHOP_ID = E.SHOP_ID and D.SHOP_ID = E.SHOP_ID and E.IS_DELETE = '0' and rownum = 1) as countCoupon,(select COUPON_TYPE from COUPON F where A.SHOP_ID = F.SHOP_ID and B.SHOP_ID = F.SHOP_ID and D.SHOP_ID = F.SHOP_ID and F.IS_DELETE = '0' and rownum = 1) as firstCouponType, (select COUPON_VALUE from COUPON G where A.SHOP_ID = G.SHOP_ID and B.SHOP_ID = G.SHOP_ID and D.SHOP_ID = G.SHOP_ID and G.IS_DELETE = '0' and rownum = 1) as firstCouponName from CUST_SHARE_INFO A, SHOP B,CUST_POINT_RECORD C,COUPON D where A.CUST_ID = #{custId} and A.SHOP_ID = B.SHOP_ID and A.SHOP_ID = D.SHOP_ID and B.SHOP_ID = D.SHOP_ID and A.CUST_ID = C.CUST_ID (+) and A.SHOP_ID = C.SHOP_ID (+) order by B.ORDER_VALUE desc")
    List<Shop3Vo> getCustShareList(@Param("custId")BigDecimal custId);
    
    //v1.0.5客户可兑换券一览抽出
    @Select("select D.*,C.SHOP_NAME,C.TOP_IMAGE_PATH from SHOP C,(select B.COUPON_ID as COUPON_ID,B.SHOP_ID as SHOP_ID,B.SHARE_TIMES as  SHARE_TIMES,B.COUPON_TYPE as COUPON_TYPE,B.COUPON_VALUE as COUPON_VALUE,B.SCAN_TIMES as SCAN_TIMES,B.EXCHANGE_TIMES as EXCHANGE_TIMES from CUST_POINT_RECORD A, COUPON B where A.CUST_ID = #{custId} and A.POINT_STATE = '0' and A.SHOP_ID = B.SHOP_ID and B.IS_DELETE = '0' and (A.POINT_NUMBER - A.POINT_SUB >= B.EXCHANGE_TIMES) ) D where C.SHOP_ID = D.SHOP_ID order by C.ORDER_VALUE")
    List<CustCanExchangeCouponVo> getCustCanExchangeCouponList(@Param("custId")BigDecimal custId);
}