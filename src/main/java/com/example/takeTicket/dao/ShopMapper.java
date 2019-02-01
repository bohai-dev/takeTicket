package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.vo.Shop4Vo;

public interface ShopMapper {
    int deleteByPrimaryKey(String shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String shopId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
    
    //根据userId查询店铺
    @Select("select * from SHOP where ADMIN_USER_ID=#{adminUserId}")
    Shop selectByAdminUserId(@Param("adminUserId")String adminUserId);

    @Select("select * from SHOP where IS_DELETE = '0' and SHOP_NAME like '%' || #{shopStr} || '%' ")
    List<Shop> likeShopStr(@Param("shopStr")String shopStr);
    
    @Update("update SHOP set SCAN_TIMES = SCAN_TIMES + #{scanNum} where SHOP_ID = #{shopId}")
    int addScanTime(@Param("shopId")String shopId,@Param("scanNum")BigDecimal scanNum);
    
    @Select("select * from SHOP where SHOP_AREA = #{shopArea}")
    List<Shop> getAreaShop(@Param("shopArea")String shopArea);
    
    //@Select("select distinct A.* from Shop A,COUPON B where A.SHOP_ID = B.SHOP_ID and  (1 = #{flg1} or A.SHOP_AREA = #{shopArea}) and (2 = #{flg2} or A.class_id = #{classId}) and (3 = #{flg3} or COUPON_TYPE = #{couponType})")
    @Select("select distinct A.*,(select EXCHANGE_TIMES from COUPON C where A.SHOP_ID = C.SHOP_ID and B.SHOP_ID = C.SHOP_ID and C.IS_DELETE = '0' and rownum = 1) as countCoupon,(select COUPON_TYPE from COUPON D where A.SHOP_ID = D.SHOP_ID and B.SHOP_ID = D.SHOP_ID and D.IS_DELETE = '0' and rownum = 1) as firstCouponType,(select COUPON_VALUE from COUPON E where A.SHOP_ID = E.SHOP_ID and B.SHOP_ID = E.SHOP_ID and E.IS_DELETE = '0' and rownum = 1) as firstCouponName from Shop A,COUPON B where A.SHOP_ID = B.SHOP_ID and A.IS_DELETE = '0' and B.IS_DELETE = '0' and  (1 = #{flg1} or A.SHOP_AREA = #{shopArea}) and (2 = #{flg2} or A.class_id = #{classId}) and (3 = #{flg3} or COUPON_TYPE = #{couponType}) order by A.ORDER_VALUE desc")
    List<Shop4Vo> getShopConditions(@Param("shopArea")String shopArea,@Param("classId")String classId,@Param("couponType")String couponType,@Param("flg1")BigDecimal flg1,@Param("flg2")BigDecimal flg2,@Param("flg3")BigDecimal flg3);
}