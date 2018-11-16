package com.example.takeTicket.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;

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
    Shop getShopInfo(String  shopId);
    
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
}
