package com.example.takeTicket.service.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takeTicket.dao.CustNshareInfoMapper;
import com.example.takeTicket.dao.CustShareInfoMapper;
import com.example.takeTicket.domain.CustNshareInfo;
import com.example.takeTicket.domain.CustShareInfo;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.CustShareService;
import com.example.takeTicket.vo.CustCanExchangeCouponVo;
import com.example.takeTicket.vo.Shop3Vo;

/**
 * Cteated by caoxx on 2018/11/6
 */
@Service
public class CustShareServiceImpl  implements CustShareService {

    @Autowired
    CustShareInfoMapper custShareInfoMapper;
    
    @Autowired
    CustNshareInfoMapper custNshareInfoMapper;

	@Override
	public void custShareInfo(String custId, String shopId) throws CouponException {
		
		CustShareInfo CustShareInfo = new CustShareInfo();
		CustShareInfo.setCustId(Long.valueOf(custId));
		CustShareInfo.setShopId(shopId);
		CustShareInfo.setShareTime(new Date());
		CustShareInfo.setBakStr("");
		CustShareInfo.setBakFlg("");
		
		
		custShareInfoMapper.insertSelective(CustShareInfo);
	}

	@Override
	public List<Shop3Vo> getCustShareList(String custId) throws CouponException {
		List<Shop3Vo> listShop = new ArrayList<>();
		listShop = custShareInfoMapper.getCustShareList(new BigDecimal(custId));
		
		
		return listShop;
	}

	@Override
	public List<CustCanExchangeCouponVo> getCustCanExchangeCouponList(String custId) throws CouponException {
		List<CustCanExchangeCouponVo> list = new ArrayList<>();
		list = custShareInfoMapper.getCustCanExchangeCouponList(new BigDecimal(custId));
		
		return list;
	}

	@Override
	public void insCustShareInfo(String custId, String shopId, String shareStyle) throws CouponException {
		CustNshareInfo custNshareInfo = new CustNshareInfo();
		custNshareInfo.setCustId(Long.valueOf(custId));
		custNshareInfo.setShopId(shopId);
		custNshareInfo.setShareStyle(shareStyle);
		custNshareInfo.setControlFlg("");
		custNshareInfo.setShareTime(new Date());
		custNshareInfo.setBakStr("");
		custNshareInfo.setBakFlg("");
		
		
		custNshareInfoMapper.insertSelective(custNshareInfo);
		
	}

	@Override
	public void updShareStatue(String shareStyle) throws CouponException {
		
		custNshareInfoMapper.updShareStatue(shareStyle);
		
	}

	@Override
	public String checkShareStatue(String custId, String shopId, String shareStyle) throws CouponException {
		String ret = "0";
		
		CustNshareInfo custNshareInfo = new CustNshareInfo();
		
		custNshareInfo = custNshareInfoMapper.checkShareStatue(custId,shopId,shareStyle);
		
		if(null == custNshareInfo) {
			//可以加点'
			ret = "1";
			
		} else {
			//已经存在不能加点
			ret = "0";
		}
		
		return ret;
	}



	

    
}
