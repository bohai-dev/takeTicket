package com.example.takeTicket.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.takeTicket.domain.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(String shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String shopId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
    
    @Select("select * from SHOP where SHOP_NAME like '%' || #{shopStr} || '%' ")
    List<Shop> likeShopStr(@Param("shopStr")String shopStr);
    
    @Update("update SHOP set SCAN_TIMES = SCAN_TIMES + #{scanNum} where SHOP_ID = #{shopId}")
    int addScanTime(@Param("shopId")String shopId,@Param("scanNum")BigDecimal scanNum);
}