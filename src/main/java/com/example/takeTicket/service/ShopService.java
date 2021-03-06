package com.example.takeTicket.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.vo.Shop2Vo;
import com.example.takeTicket.vo.Shop4Vo;

/**
 * Cteated by caoxx on 2018/11/6
 */
public interface ShopService {



    /**
     * 根据条件查询店铺
     * @param shop
     * @return
     */
    List<Shop> likeShopStr(String  shopStr);
    
    /**
     * 根据ID 查询店铺
     * @param shop
     * @return
     */
    Shop2Vo getShopInfo(String  shopId);
    
    /**
     * 按照店铺名查找优惠
     * @param shop
     * @return
     */
    List<Coupon> getShopIdfindCoupon(String  shopStr);
    
    
    /**
     * 店铺游览次数+num
     * @param shop
     * @return
     */
    void addScanTime(String shopId,BigDecimal scanNum);
    
    /**
     * 根据地域查询店铺
     * @param shop
     * @return
     */
    List<Shop> getAreaShop(String  shopArea);
    
    /**
     * 根据条件查询店铺v1.0.4
     * @param shop
     * @return
     */
    List<Shop4Vo> getShopConditions(String  shopArea,String classId,String couponType);
    
}
