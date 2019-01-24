package com.example.takeTicket.service.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takeTicket.dao.CouponMapper;
import com.example.takeTicket.dao.ShopMapper;
import com.example.takeTicket.dao.SpecialDishesMapper;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.domain.SpecialDishes;
import com.example.takeTicket.service.ShopService;
import com.example.takeTicket.vo.Shop2Vo;
import com.example.takeTicket.vo.Shop4Vo;

/**
 * Cteated by caoxx on 2018/11/6
 */
@Service
public class ShopServiceImpl  implements ShopService {

    @Autowired
    ShopMapper shopMapper;

    @Autowired
    CouponMapper couponMapper;
    
    @Autowired
    SpecialDishesMapper specialDishesMapper;

	@Override
	public List<Shop> likeShopStr(String shopStr) {
		List<Shop> listShop = new ArrayList<Shop>();
		listShop = shopMapper.likeShopStr(shopStr);
		return listShop;
	}

	@Override
	public List<Coupon> getShopIdfindCoupon(String shopStr) {
		List<Coupon> listCoupon = new ArrayList<Coupon>();
		
		listCoupon = couponMapper.getShopIdfindCoupon(shopStr);
		
		return listCoupon;
	}

	@Override
	public void addScanTime(String shopId, BigDecimal scanNum) {
		
		shopMapper.addScanTime(shopId,scanNum);
		
	}

	@Override
	public Shop2Vo getShopInfo(String shopId) {
		Shop shopRet = new Shop();
		shopRet = shopMapper.selectByPrimaryKey(shopId);
		
		Shop2Vo shop2Vo = new Shop2Vo();
		BeanUtils.copyProperties(shopRet, shop2Vo);
		
		List<SpecialDishes> listSpecialDishes = specialDishesMapper.getSpecialDishes(shopId);
		
		shop2Vo.setSpecialDishes(listSpecialDishes);
		return shop2Vo;
	}

	@Override
	public List<Shop> getAreaShop(String shopArea) {
		List<Shop> listShop = new ArrayList<Shop>();
		listShop = shopMapper.getAreaShop(shopArea);
		return listShop;
	}

	@Override
	public List<Shop4Vo> getShopConditions(String shopArea, String classId, String couponType) {
		List<Shop4Vo> listShop = new ArrayList<Shop4Vo>();
		BigDecimal flg1 = new BigDecimal(0);
		BigDecimal flg2 = new BigDecimal(0);
		BigDecimal flg3 = new BigDecimal(0);
		if("".equals(shopArea) || null == shopArea){
			flg1 = new BigDecimal(1);
		} 
		
		if("".equals(classId) || null == classId){
			flg2 = new BigDecimal(2);
		} 
		
		if("".equals(couponType) || null == couponType){
			flg3 = new BigDecimal(3);
		} 
		
		listShop = shopMapper.getShopConditions(shopArea,classId,couponType,flg1,flg2,flg3);
		return listShop;
	}


    
}
