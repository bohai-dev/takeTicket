package com.example.takeTicket.service.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takeTicket.dao.ShopMapper;
import com.example.takeTicket.dao.couponMapper;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.service.ShopService;

/**
 * Cteated by caoxx on 2018/11/6
 */
@Service
public class ShopServiceImpl  implements ShopService {

    @Autowired
    ShopMapper shopMapper;

    @Autowired
    couponMapper couponMapper;

	@Override
	public List<Shop> likeShopStr(String shopStr) {
		List<Shop> listShop = new ArrayList<Shop>();
		listShop = shopMapper.likeShopStr(shopStr);
		return null;
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


    
}
